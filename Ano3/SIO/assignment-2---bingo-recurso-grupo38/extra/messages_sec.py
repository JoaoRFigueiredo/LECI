import json
import select
import os
import sys
sys.path.append(os.path.dirname(os.getcwd())+"/playing_area")
sys.path.append(os.path.dirname(os.getcwd())+"/player")
sys.path.append(os.path.dirname(os.getcwd())+"/extra")
sys.path.append(os.path.dirname(os.getcwd())+"/caller")



def send_message(s, message):
    """
    Sends the given message over the socket s.
    """
    
    # Decode any bytes objects in the message into strings
    def convert_bytes(obj):
        if isinstance(obj, dict):
            return {k: convert_bytes(v) for k, v in obj.items()}
        if isinstance(obj, bytes):
            return obj.decode('latin-1')
        return obj

    # Serialize the message as a JSON string and send it over the socket
    #print(json.dumps(message, default=convert_bytes).encode('UTF-8'))
    s.sendall(json.dumps(message, default=convert_bytes).encode('UTF-8'))




def receive_message(s):
    """
    Receives and returns a message from the socket s.
    """
    
    data = b''
    while True:
    
        ready, _, _ = select.select([s], [], [], 1)  # Set a 1 second timeout
        if not ready:  # Timeout occurred
            return None
        chunk = s.recv(1024)
        
        if chunk == b'':
            raise RuntimeError('Socket connection broken')
        data += chunk
        if not select.select([s], [], [], 0)[0]:
            try:
                # print(data)
                # print('----------')
                # print(data.decode('latin-1'))
                # print('----------------')
                # print(json.loads(data.decode('latin-1')))
                # print('------------')
                return json.loads(data.decode('latin-1'))
            except json.decoder.JSONDecodeError:
                pass

