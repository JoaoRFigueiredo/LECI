
# Module: tree_search
# 
# This module provides a set o classes for automated
# problem solving through tree search:
#    SearchDomain  - problem domains
#    SearchProblem - concrete problems to be solved
#    SearchNode    - search tree nodes
#    SearchTree    - search tree with the necessary methods for searhing
#
#  (c) Luis Seabra Lopes
#  Introducao a Inteligencia Artificial, 2012-2019,
#  Inteligência Artificial, 2014-2019

from abc import ABC, abstractmethod

# Dominios de pesquisa
# Permitem calcular
# as accoes possiveis em cada estado, etc
class SearchDomain(ABC):

    # construtor
    @abstractmethod
    def __init__(self):
        pass

    # lista de accoes possiveis num estado
    @abstractmethod
    def actions(self, state):
        pass

    # resultado de uma accao num estado, ou seja, o estado seguinte
    @abstractmethod
    def result(self, state, action):
        pass

    # custo de uma accao num estado
    @abstractmethod
    def cost(self, state, action):
        pass

    # custo estimado de chegar de um estado a outro
    @abstractmethod
    def heuristic(self, state, goal):
        pass

    # test if the given "goal" is satisfied in "state"
    @abstractmethod
    def satisfies(self, state, goal):
        pass


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
    def __init__(self,state,parent,cost, heuristic = 0, action = None): 
        self.state = state
        self.parent = parent
        self.depth = 0 if parent == None else parent.depth +1
        self.cost = cost
        self.heuristic = heuristic #ex12
        self.action = action

    def __str__(self):
        return "no(" + str(self.state) + "," + str(self.parent) + ")"
    def __repr__(self):
        return str(self)

# Arvores de pesquisa
class SearchTree:

    # construtor
    def __init__(self,problem, strategy='breadth'): 
        self.problem = problem
        root = SearchNode(problem.initial, None, 0, self.problem.domain.heuristic(self.problem.initial, self.problem.goal))
        self.open_nodes = [root]
        self.strategy = strategy
        self.solution = None
        self.highest_cost_nodes = [root]
        self.terminals = 0
        self.non_terminals = 0
        self.average_depth = 0


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


    # procurar a solucao
    def search(self, limit = None):
        self.non_terminals = 0 #EX5
        while self.open_nodes != []:
            node = self.open_nodes.pop(0)
            if self.problem.goal_test(node.state):
                self.solution = node
                self.terminals = len(self.open_nodes) +1 #EX5
                self.average_depth = self.terminals + self.non_terminals #ex16
                #self.plan = self.get_plan(node)
                return self.get_path(node)
            self.non_terminals +=1 #EX5
            #ex4
            if limit == None or node.depth < limit:
                lnewnodes = []
                for a in self.problem.domain.actions(node.state):
                    newstate = self.problem.domain.result(node.state,a)
                    #ex1- verificar se o novo estado representa um nó já conhecido
                    if newstate not in self.get_path(node):
                        newnode = SearchNode(newstate,node, node.cost+self.problem.domain.cost(node.state, a), self.problem.domain.heuristic(newstate, self.problem.goal), a) #ex12
                        lnewnodes.append(newnode)
                        #self.average_depth += newnode.depth #ex16
                        if newnode.cost == self.highest_cost_nodes[0].cost:#ex15
                            self.highest_cost_nodes.append(newnode)
                        if newnode.cost > self.highest_cost_nodes[0].cost:#ex15
                            self.highest_cost_nodes = [newnode]
                        
                self.add_to_open(lnewnodes)
        return None

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
        
            

