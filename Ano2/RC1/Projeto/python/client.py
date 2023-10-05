
import socket
from time import sleep
import psutil
import json
import sys




speed = None

sock_info = None


def get_pc_info():

    cpu = psutil.cpu_percent()
    memory = psutil.virtual_memory()

    return json.dumps({"cpu" : cpu , "memory" : memory})


def get_input():
    print("Server ip: ")
    IP = input()
    print("Server port:")
    PORT = int(input())
    print("Transmission rate (in  milliseconds)")
    VELOCITY = int(input())
    while VELOCITY < 50:
        print("Transmission rate should be greater than 50ms")
        print("Transmission rate (in  milliseconds): ")
        VELOCITY = int(input())
    return [IP , PORT , VELOCITY]


client_sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

def try_reconnection(client_sock , sock_ip_port):
    counter = 0
    connected = False 
    while not connected:  

        try:  
            client_sock.connect(sock_ip_port)  
            connected = True  
            print( "Connection successful" )  
        except socket.error:
            print("Unable to connect, server is not responding!")
            counter +=1
            if counter > 3:
                print("Maybe the server is in another port or IP address, try again later!")
                print("Exiting application")
                sys.exit(0)
            sleep(1)  



def socket_function():


    global sock_info
    global client_sock

    print("Welcome to client application!")

    while True:
        try:
            data = get_input()
            sock_info = (data[0] , data[1])
            try_reconnection(client_sock , sock_info)
            speed = data[2]
            break
        except Exception as error:
            print(error)
        

    while True:
        try:
            data = get_pc_info()
            message = len(data).to_bytes(4,'big') + data.encode('utf-8')
            print("sending message : " + str(message))
            client_sock.send(message)

            data = client_sock.recv(1024).decode('utf-8')
            
            info = json.loads(data)
            
            print("Server said: " + str(info["message"]) + "(status:" + str(info["status"])+")")
            
            
        except socket.error:
            print("Connection lost, reconnecting " + str(sock_info))
            try_reconnection(client_sock , sock_info)

        sleep(speed / 1000)


        



if __name__ == "__main__":
    socket_function()