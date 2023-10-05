from Domain import Domain as dom
import heapq
import time

# Module: tree_search
# 
# This module provides a set o classes for automated
# problem solving through tree search:
#    rushHour - problem domains
#    SearchProblem - concrete problems to be solved
#    SearchNode    - search tree nodes
#    SearchTree    - search tree with the necessary methods for searhing
#
#  (c) Luis Seabra Lopes
#  Introducao a Inteligencia Artificial, 2012-2019,
#  Inteligência Artificial, 2014-2019


  

# Problemas concretos a resolver
# dentro de um determinado dominio
class SearchProblem:
    def __init__(self, domain, initial, goal):
        self.domain = domain
        self.initial = initial
        self.goal = goal

        
    def goal_test(self, state):
        return self.domain.satisfies(state,self.goal)

# Nos de uma arvore de pesquisa
class SearchNode:
    def __init__(self,state,parent): 
        self.state = state
        self.parent = parent
        #elf.depth = 0 if parent == None else parent.depth +1
        #self.cost = cost
        #self.heuristic = heuristic #ex12
        

    def __str__(self):
        return "no(" + str(self.state) + "," + str(self.parent) + ")"
    def __repr__(self):
        return str(self)


class SearchTree:
    def __init__(self, game_state, time_cost_factor=1):
        self.nodes = {}
        self.queue = []
        self.visited = set()
        self.dimensions = game_state['dimensions']
        
        grid = game_state['grid'].split(" ")[1]
        self.nodes[grid] = (grid, None, 0, 0, ("", (0, 0), (0,)), game_state['cursor'])
        heapq.heappush(self.queue, (0, grid))

        goal_idx = grid.index('A')
        y = int(goal_idx / self.dimensions[0])
        self.goal_position = (y + 1) * self.dimensions[0] - 1
        

    def search(self):
        while self.queue:
            node_value, node = heapq.heappop(self.queue)
            node = self.nodes[node]
            if node[0] in self.visited:
                continue
            self.visited.add(node[0])
            
            if node[0][self.goal_position] == 'A':
                plan = []
                n = node
                while n[1]:
                    plan = [n[4]] + plan
                    n = n[1]
                return plan

            for action in dom.actions(node[0]):
                new_state, new_cursor = dom.result(node, action)
                if new_state in self.nodes:
                    continue

                cost = node[2] + dom.cost(action, node, new_cursor)
                heuristic = dom.heuristic(node, new_state, self.goal_position, self.dimensions, 2)
                total_cost = cost + heuristic
                new_node = (new_state, node, cost, heuristic, action, new_cursor)
                self.nodes[new_state] = new_node
                heapq.heappush(self.queue, (total_cost, new_state))
      
    
      
      
      #EX3
    @property
    def length(self):
        return self.solution.depth

    #EX6
    @property
    def avg_branching(self):
        return (self.terminals + self.non_terminals -1) / (self.non_terminals)

    #EX9
    @property
    def cost(self):
        return self.solution.cost

    @property
    def plan(self):
        return self.get_plan(self.solution)

    # obter o caminho (sequencia de estados) da raiz ate um no
    def get_path(self,node):
        if node.parent == None:
            return [node.state]
        path = self.get_path(node.parent)
        path += [node.state]
        return(path)

    def get_plan(self, node):
        actions = []
        while node.action != None:
            actions.insert(0, node.action)
            node = node.parent
        return actions

    # juntar novos nos a lista de nos abertos de acordo com a estrategia
    def add_to_open(self,lnewnodes):
        if self.strategy == 'breadth':
            self.open_nodes.extend(lnewnodes)
        elif self.strategy == 'depth':
            self.open_nodes[:0] = lnewnodes
        elif self.strategy == 'uniform':#ex10
            self.open_nodes.extend(lnewnodes)
            self.open_nodes.sort(key = lambda x : x.cost) # tem que se ver o de menor custo
        elif self.strategy == 'greedy':#ex13
            self.open_nodes.extend(lnewnodes)
            self.open_nodes.sort(key = lambda x : x.heuristic)
        elif self.strategy == 'a*': #ex14
            self.open_nodes.extend(lnewnodes)
            self.open_nodes.sort(key = lambda x : x.heuristic + x.cost)
           

