
from typing import List
import  socket
import select
import json
import os.path
from dataclasses import dataclass
from datetime import date, datetime
from pynput import keyboard
from threading import Thread

@dataclass
class statistics:
    total_clients: int
    packets_received:int
    bytes_received:int
    packets_sent:int
    bytes_sent:int


clients = []

log_file = None

stats = statistics(0,0,0,0,0)



console_print = True



def on_press(key):
    global console_print
    global log_file
    if key == keyboard.Key.esc:
        if log_file != None:
            save_statistics()
            write_info("SESSION ENDED")
            log_file.close()
            
        
        print("Log file successfully saved!")
        
        print("Goodbye!")
        os._exit(0)
    if key == keyboard.Key.f1:
        console_print = not console_print
        if console_print:
            print("console print activated!")
        else:
            print("Console print deactivated!")


def on_release(key):
    return          

def keyboard_input():
    with keyboard.Listener(
        on_press=on_press,
        on_release=on_release) as listener:
            listener.join()


def save_statistics():
    global stats
    global log_file
    if log_file != None:
        write_info("STATISTICS:")
        write_info("Packets received: " + str(stats.packets_received))
        write_info("Packets sent    : " + str(stats.packets_sent))
        write_info("Bytes received  : " + str(stats.bytes_received))
        write_info("Bytes sent      : " + str(stats.bytes_sent))
    


def write_info(info):
    global log_file
    final_str = "[" + str(datetime.now()) + "] " + info
    if console_print:
        print(final_str)
    if log_file != None:
        log_file.writelines([final_str + '\n'])


def get_message(client_sock):
    global stats
    _size = int.from_bytes(client_sock.recv(4) , 'big')

    message = client_sock.recv(_size)

    stats.bytes_received += _size + 4
    stats.packets_received += 1
    
    return json.loads(message)



def get_input():
    print("Server ip: ")
    IP = input()
    if(IP == "default"):
        return ('127.0.0.1' , 5050 , True ,  "log.txt")
    print("Server port:")
    PORT = int(input())
    print("Save client data received in a log file (y/n): ")
    save = input()
    ret_save = False
    if save != 'y' and save != 'n':
         raise ValueError("Expected 'y' or 'n' characeter")
    else:
        
        file_name = None
        if save == 'y':
            ret_save = True
            print("Enter file name: ")
            file_name = input()
            if os.path.isfile(file_name):
                raise ValueError(file_name + " aldready exists, please enter a non existing file name.")

    return (IP , PORT , ret_save ,  file_name)
    



def socket_input():

    global stats
    global log_file
    print("Server program started, welcome!")
    print("if you want to use default parameters (ip:127.0.0.1,port:5050,write data to 'log.txt') please enter 'default' keyword in ip address parameter")
    print("Press 'esc' to exit (avoid closing with other means)")
    print("Press 'f1' to activate/deactivate console printing")


    server_socket = socket.socket(socket.AF_INET , socket.SOCK_STREAM)

    while True:
        try:
            param = get_input()
            server_socket.bind((param[0] , param[1]))
            if param[2] == True:
                log_file = open(param[3] , "a")
                write_info("STARTING NEW SESSION, WAITING FOR CLIENTS")
            break

        except Exception as ex:
            print(ex)

    server_socket.listen(10)

    while True:
        try:
            available = select.select([server_socket] + clients , [] , [])[0]
        except ValueError:
            #socket may have been closed
            for client_sock in clients:
                if client_sock.fileno() == - 1:
                    client_sock.remove(client_sock)
                continue
        
        for client_sock in available:

            
            if client_sock is server_socket:    #new client
                newclient , addr = server_socket.accept()
                clients.append(newclient)

                write_info("new client : " + str(newclient))


            else:
                try:
                    if len (client_sock.recv (1, socket.MSG_PEEK)) != 0:
                        #decode message in json format
                        try:
                            
                            json_message = get_message(client_sock)

                            if "cpu" in json_message and "memory" in json_message:
                                info = "From client " + str(client_sock.getpeername()) + ": " + "cpu usage -> " + str(json_message["cpu"]) + ", memory usage -> " + str(json_message["memory"][3]) + " bytes."
                                write_info(info)
                                bin_message = b'{"status":"OK","message":"Packet received is correct!"}'
                                client_sock.sendall(bin_message)
                                stats.packets_sent += 1
                                stats.bytes_sent += len(bin_message)
                                
                            
                            else:

                                info = "cpu usage or memory field not found! " + "Client removed: " + str(client_sock)
                                write_info(info)
                                bin_message = b'{"status":"ERROR","message":"cpu usage or memory field not found!"'
                                client_sock.sendall(bin_message)
                                stats.packets_sent += 1
                                stats.bytes_sent += len(bin_message)

                                if log_file != None:
                                    log_file.write(info)
                                clients.remove(client_sock)
                                client_sock.close()

                        except:
                            write_info("error getting message from " + str(client_sock))
 
                
                except:

                    write_info("Client removed: " + str(client_sock))
                    clients.remove(client_sock)
                    client_sock.close()
                    break


if __name__ == "__main__":
    t1 = Thread(target = keyboard_input)
    t2 = Thread(target = socket_input)

    t1.start()
    t2.start()