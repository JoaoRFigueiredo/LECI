#João Ricardo Cidra Figueiredo, 98506
#Code (general understanding of the questions) discussed with the following colleagues:
#Pedro Filipe Pereira Santos 98158
#Rafael Amorim 98197

from tree_search import *
from cidades import *
from blocksworld import *
import math


def func_branching(connections,coordinates):
    #IMPLEMENT HERE
    neighbours = []

    #calculate number of neighours for every city in coordinates
    for coord in coordinates:
       neighbours.append(len(func_actions(connections, coord)))

    neighbours_sum = sum(neighbours)
    branching = neighbours_sum/len(neighbours) -1
    return branching

                

class MyCities(Cidades):
    def __init__(self,connections,coordinates):
        super().__init__(connections,coordinates)
        # ADD CODE HERE IF NEEDED
        self.branching = func_branching(connections, coordinates)

class MySTRIPS(STRIPS):
    def __init__(self,optimize=False):
        super().__init__(optimize)

    def simulate_plan(self,state,plan):
        #IMPLEMENT HERE
        newstate = state
        for act in plan:
            newstate = self.result(newstate, act)
        return newstate
             
class MyNode(SearchNode):
    def __init__(self,state,parent, cost, heuristic, depth):
        super().__init__(state,parent)
        #ADD HERE ANY CODE YOU NEED
        self.cost = cost
        self.heuristic = heuristic
        self.depth = depth

class MyTree(SearchTree):

    def __init__(self,problem, strategy='breadth',optimize=0,keep=0.25): 
        super().__init__(problem,strategy)
        #ADD HERE ANY CODE YOU NEED
        self.terminals = 0
        self.optimize = optimize
        self.keep = keep
        if optimize == 0:
            root = MyNode(problem.initial, None,0, self.problem.domain.heuristic(problem.initial, problem.goal), 0)
            self.all_nodes = [root]
        elif optimize == 1: #optimized = 1, so nodes are represented by tuples
            #update tuples as state-parent-cost-heuristic-depth
            #previously i had state-parent-depth-cost-heursitic
            root = [problem.initial, None, 0, self.problem.domain.heuristic(problem.initial, problem.goal), 0]
            self.all_nodes = [root]
        elif optimize == 2 or 4: #optimized = 2 or 4, so nodes, domains  and problems are represented by tuples
            #self.problem = problem
            domain, initial, goal = problem
            f_actions, f_result, f_cost, f_heuristic, f_satisfies, branching = domain
            root = [initial, None, 0, f_heuristic(initial, goal), 0]
            self.all_nodes = [root]
            self.open_nodes = [0]
            

    def astar_add_to_open(self,lnewnodes):
        #IMPLEMENT HERE
        self.open_nodes.extend(lnewnodes)
        if self.optimize == 0:
            return self.open_nodes.sort(key = lambda x : self.all_nodes[x].cost + self.all_nodes[x].heuristic)
        else:
            return self.open_nodes.sort(key = lambda x : self.all_nodes[x][2] + self.all_nodes[x][3])

    # remove a fraction of open (terminal) nodes
    # with lowest evaluation function
    # (used in Incrementally Bounded A*)
    def forget_worst_terminals(self):
        #IMPLEMENT HERE
        #d = depth medio dos nos na fila
        number_nodes_depth = self.nodes_depth(self.average_depth())
        max_nodes_given_depth = self.branching * number_nodes_depth #(?)
        num_keep = max_nodes_given_depth*self.keep
        return math.trunc(num_keep) + 1



    # procurar a solucao
    def search2(self):
        #IMPLEMENT HERE
        #search se
        #search without any optimization, usando o MyNode
        if self.optimize == 0:
            while self.open_nodes != []:
                nodeID = self.open_nodes.pop(0)
                node = self.all_nodes[nodeID]
                if self.problem.goal_test(node.state):
                    self.solution = node
                    self.terminals = len(self.open_nodes)+1
                    return self.get_path(node)
                lnewnodes = []
                self.non_terminals += 1
                for a in self.problem.domain.actions(node.state):
                    newstate = self.problem.domain.result(node.state,a)
                    if newstate not in self.get_path(node):
                        newnode = MyNode(newstate,nodeID, node.cost + self.problem.domain.cost(node.state, a), self.problem.domain.heuristic(newstate, self.problem.goal), node.depth +1)
                        lnewnodes.append(len(self.all_nodes))
                        self.all_nodes.append(newnode)
                self.add_to_open(lnewnodes)
                #search is optimized, by representing nodes with tuples
        if self.optimize == 1:
            while self.open_nodes != []:
                nodeID = self.open_nodes.pop(0)
                node = self.all_nodes[nodeID]
                state = node[0]
                parent = node[1]
                depth = node[4]
                cost = node[2]
                heuristic = node[3]
                if self.problem.goal_test(state):
                    self.solution = node
                    self.terminals = len(self.open_nodes)+1
                    #self.problem.domain.branching = func_branching()
                    return self.get_path_optimized(node)
                lnewnodes = []
                self.non_terminals += 1
                for a in self.problem.domain.actions(state):
                    newstate = self.problem.domain.result(state,a)
                    if newstate not in self.get_path_optimized(node):
                        newnode = (newstate,nodeID, cost + self.problem.domain.cost(state, a), self.problem.domain.heuristic(newstate, self.problem.goal), depth +1)
                        lnewnodes.append(len(self.all_nodes))
                        self.all_nodes.append(newnode)
                self.add_to_open(lnewnodes)
        #search with more optimizations        
        if self.optimize == 2 :
            while self.open_nodes != []:
                nodeID = self.open_nodes.pop(0)
                node = self.all_nodes[nodeID]
                state = node[0]
                parent = node[1]
                depth = node[4]
                cost = node[2]
                heuristic = node[3]
                domain, initial, goal = self.problem #Problem as a tuple
                f_actions, f_result, f_cost, f_heuristic,f_satisfies, branching = domain # domain as a tuple
                if f_satisfies(state, goal):
                    self.solution = node
                    self.terminals = len(self.open_nodes)+1
                    #self.problem.domain.branching = func_branching()
                    return self.get_path_optimized(node)
                lnewnodes = []
                self.non_terminals += 1
                for a in self.problem[0][0](state):
                    newstate = self.problem[0][1](state,a)
                    if newstate not in self.get_path_optimized(node):
                        newnode = (newstate,nodeID, cost + self.problem[0][2](state, a), self.problem[0][3](newstate, self.problem[2]), depth +1)
                        lnewnodes.append(len(self.all_nodes))
                        self.all_nodes.append(newnode)
                self.add_to_open(lnewnodes)
        #search with more optimizations (graph search)
        if self.optimize == 4:
            while self.open_nodes != []:
                nodeID = self.open_nodes.pop(0)
                node = self.all_nodes[nodeID]
                state = node[0]
                parent = node[1]
                depth = node[4]
                cost = node[2]
                heuristic = node[3]
                domain, initial, goal = self.problem #Problem as a tuple
                f_actions, f_result, f_cost, f_heuristic,f_satisfies, branching = domain # domain as a tuple
                if f_satisfies(state, goal):
                    self.solution = node
                    self.terminals = len(self.open_nodes)+1
                    #self.problem.domain.branching = func_branching()
                    return self.get_path_optimized(node)
                lnewnodes = []
                self.non_terminals += 1
                for a in self.problem[0][0](state):
                    newstate = self.problem[0][1](state,a)
                    if newstate not in self.get_path_optimized(node):
                        newnode = (newstate,nodeID, cost + self.problem[0][2](state, a), self.problem[0][3](newstate, self.problem[2]), depth +1)
                        isThere = False
                        for n in self.all_nodes:
                            if n[0] == newstate:
                                isThere = True
                                if n[2] > newnode[2]:
                                    i = self.all_nodes.index(n)
                                    self.all_nodes[i] = newnode
                            
                        if not isThere:
                            #self.non_terminals += 1
                            lnewnodes.append(len(self.all_nodes))
                            self.all_nodes.append(newnode)

                self.add_to_open(lnewnodes)
        return None
        

# If needed, auxiliary functions can be added
    #
    #auxiliary function about get_path for nodes as tuples
    #Since i can't change the one in tree_search, i'll just make a slighty different version of it, so that it works 
    #with the optimized search
    def get_path_optimized(self,node):
            if node[1] == None:
                return [node[0]]
            path = self.get_path_optimized(self.all_nodes[node[1]])
            path += [node[0]]
            return(path)

    #extra functions

    def average_depth(self):
        averages = []
        if self.optimize == 0:
            for n in self.all_nodes:
                averages.append(n.depth)
        else:
            for n in self.all_nodes:
                averages.append(n[4])

        return sum(averages)/len(averages)

    def nodes_depth(self, depth):
        total = 0
        if self.optimize == 0:
            for n in self.all_nodes:
                if n.depth == depth:
                    total +=1
        else:
            for n in self.all_nodes:
                if n[4] == depth:
                    total += 1

        return total



