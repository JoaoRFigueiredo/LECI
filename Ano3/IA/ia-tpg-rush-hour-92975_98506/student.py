"""Example client."""
import asyncio
import getpass
import json
import os
import threading
from Domain import Domain as dom
import tree_search
import websockets


#obtem a próxima jogada. 
def getNextMove(game, plan):
    if not plan or not plan:
        return None, None

    piece, direction, size_car, positions = plan[0]
    grid = game["grid"].split(" ")[1]
    size = game["dimensions"]
    move_impossible = (
        (direction == 'a' and grid[positions[0] - 1] != "o") or
        (direction == 'd' and grid[positions[-1] + 1] != "o") or
        (direction == 'w' and grid[positions[0] - size[1]] != "o") or
        (direction == 's' and grid[positions[-1] + size[1]] != "o")
    )
    if move_impossible:
        return None, None

    cur = game["cursor"]
    selected = game["selected"]
    pos0 = (positions[0] % size[0], positions[0] // size[1])
    pos1 = (positions[-1] % size[0], positions[-1] // size[1])
    dist0 = (cur[0] - pos0[0], cur[1] - pos0[1])
    dist1 = (cur[0] - pos1[0], cur[1] - pos1[1])
    dist = dist0 if abs(dist0[0]) + abs(dist0[1]) <= abs(dist1[0]) + abs(dist1[1]) else dist1

    if selected == piece:
        plan.pop(0)
        if direction == 'a':
            return "a", plan
        elif direction == 'd':
            return "d", plan
        elif direction == 'w':
            return "w", plan
        elif direction == 's':
            return "s", plan
    elif selected:
        return " ", plan
    elif dist[0] > 0:
        return "a", plan
    elif dist[0] < 0:
        return "d", plan
    elif dist[1] > 0:
        return "w", plan
    elif dist[1] < 0:
        return "s", plan
    elif grid[cur[1] * size[0] + cur[0]] == piece:
        return " ", plan

    return None, None

def run_search(game, plan, thinking):
    if not thinking[0]:
        thinking[0] = True
        tree = tree_search.SearchTree(game)
        plan[0] = tree.search()
        thinking[0] = False

async def agent_loop(server_address="localhost:8000", agent_name="student"):
    async with websockets.connect(f"ws://{server_address}/player") as websocket:
        await websocket.send(json.dumps({"cmd": "join", "name": agent_name}))
        game = json.loads(await websocket.recv())
        #print(game)
        plan = [None]
        thinking = [False]
        while True:
            game = json.loads(await websocket.recv())
            if thinking[0]:
                continue
            if not plan[0]:
                thread = threading.Thread(target=run_search, args=(game, plan, thinking))
                thread.start()
                await asyncio.sleep(0)
                continue
            key, plan[0] = getNextMove(game, plan[0])
            if key:
                await websocket.send( json.dumps({"cmd": "key", "key": key}) )
                    
# DO NOT CHANGE THE LINES BELLOW
# You can change the default values using the command line, example:
# $ NAME='arrumador' python3 client.py
loop = asyncio.get_event_loop()
SERVER = os.environ.get("SERVER", "localhost")
PORT = os.environ.get("PORT", "8000")
NAME = os.environ.get("NAME", getpass.getuser())
loop.run_until_complete(agent_loop(f"{SERVER}:{PORT}", NAME))



