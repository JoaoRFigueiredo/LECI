#encoding: utf8

# YOUR NAME: João Ricardo Cidra Figueiredo
# YOUR NUMBER:98506

# COLLEAGUES WITH WHOM YOU DISCUSSED THIS ASSIGNMENT:
# Pedro Filipe Pereira Santos 98158
# Rafael Amorim 98197

from semantic_network import *
from bayes_net import *
from constraintsearch import *


class MySN(SemanticNetwork):

    def __init__(self):
        SemanticNetwork.__init__(self)
        # ADD CODE HERE IF NEEDED
        pass

    def is_object(self,user,obj):
        # IMPLEMENT HERE
        lst = set([d.relation.entity1 for d in self.query_local(user, None, None, None) if isinstance(d.relation, Member)] +
        [d.relation.entity1 for d in self.query_local(user, None, None, None) if (isinstance(d.relation, Association) and (d.relation.card == None))] +
        [d.relation.entity2 for d in self.query_local(user, None, None, None) if (isinstance(d.relation, Association) and (d.relation.card == None))])
        if obj in lst:
            return True
        return False

    def is_type(self,user,type):
        # IMPLEMENT HERE
        lst = set([d.relation.entity2 for d in self.query_local(user, None, None, None) if isinstance(d.relation, Subtype) or isinstance(d.relation, Member) or d.relation.card == "one" or d.relation.card == "many"])
        if type in lst:
            return True
        return False

        # return lst

    def infer_type(self,user,obj,xpto=0):
        # IMPLEMENT HERE
        if xpto == 0:
            for d in self.declarations:
                if d.user == user and d.relation.entity1 == obj and (isinstance(d.relation, Member) or isinstance(d.relation, Subtype)):
                    return d.relation.entity2
                
                elif d.user == user and d.relation.entity2 == obj and isinstance(d.relation, Association):
                    if self.infer_signature(user, d.relation.name) != None:
                        t1,t2 = (self.infer_signature(user, d.relation.name))
                        return t2
                    
            return None

        elif xpto == 1:
            for d in self.declarations:
                if d.user == user and d.relation.entity2 == obj and isinstance(d.relation, Association):
                    if d.relation.card == None:
                        return "__unknown__"
                    else:
                        return d.relation.entity2
                if d.user == user and d.relation.entity1 == obj and isinstance(d.relation, Association):
                    if d.relation.card == None:
                        return "__unknown__"
                    else:
                        return d.relation.entity1
                    

 
    def infer_signature(self,user,assoc,xpto=0):
        # IMPLEMENT HERE
        st = set()
        for d in self.declarations:
            if d.user == user and d.relation.name == assoc and isinstance(d.relation, Association):
                (t1,t2) = ( self.infer_type(user, d.relation.entity1, 0), self.infer_type(user, d.relation.entity2, 1) )
                if t2 != "__unknown__":
                    return (d.relation.entity1, t2)
                st.add((t1, t2))

        if len(st) == 1:
            return st.pop() 

        return None


class MyBN(BayesNet):

    def __init__(self):
        BayesNet.__init__(self)
        # ADD CODE HERE IF NEEDED
        pass

    def markov_blanket(self,var):
        # IMPLEMENT HERE
        lst = []
        filhos = []
        dic = self.dependencies
        newdic = {}

        for n in dic:
            n1 = []
            n2 = []
            sm = (n1, n2)
            for v in dic[n]:
                n1 += v[0]
                n2 += v[1]
            sm = list(sm)
            if len(sm[0]) != 0:
                sm[0] = set(sm[0])
            if len(sm[1]) != 0:
                sm[1] = set(sm[1])
            newdic[n] = sm
        #print(newdic)

        #descobrir pais
        for n in newdic:
            if n == var:
                for v in newdic[n][0]:
                     if v in newdic[n][1]:
                        lst.append(v)
        #descobrir filhos
            if n!=var:
                if var in newdic[n][0] and var in newdic[n][1]:
                    filhos.append(n)
                    lst.append(n)
        #descobrir pais dos filhos
        for n in filhos:
            for h in newdic:
                if n == h:

                    for v in newdic[h][0]:
                        if v in newdic[h][1]:
                            if v != var:
                                lst.append(v)
       

        return lst



class MyCS(ConstraintSearch):

    def __init__(self,domains,constraints):
        ConstraintSearch.__init__(self,domains,constraints)
        # ADD CODE HERE IF NEEDED
        self.variables = [ 'T', 'W', 'O', 'U', 'R', 'F' ]
        

    def propagate(self,domains,var):
        # IMPLEMENT HERE
        edges = [ (x, y) for (x, y) in self.constraints if y == var ]
        while edges!=[]:

            (var1,var2) = edges[0]
            edges = edges[1:]

            constraint = self.constraints[var1,var2]
            domain = []
            for x in domains[var1]:
                possible = False
                for y in domains[var2]:
                    if constraint(var1,x,var2,y):
                        possible = True
                if possible:
                    domain += [x]

            if len(domain)<len(domains[var1]):
               domains[var1] = domain
               edges += [(v1,v2) for (v1,v2) in self.constraints if v2==var1]
        return domains



    def higherorder2binary(self,ho_c_vars,unary_c):
        # IMPLEMENT HERE
        #obter o dominio ao qual o aux pertence que é o produto cartesiano dos domínios das variáveis
        
        lst = []
        for x in ho_c_vars:
            lst.append(self.domains[x])
        #print(lst)
        aux = get_cart_prd(lst)
        #print(aux)
        v = "".join(ho_c_vars)
        #print(v)
        newList = []
        for dom in aux:
            if(unary_c(dom)):
                newList.append(tuple(dom))
                

        self.domains[v] = newList

        #dominios ta feito
        #fazer a parte dos constraints
        #k = []
        #self.variables.append(v)
        
        edges = [ (v,v2) for v2 in self.variables if v != v2 ]



        self.constraints = self.constraints | { e:(lambda v1,x1,v2,x2: x1!=x2) for e in edges }
        self.variables.append(v)
        #self.constraints = self.constraints | newc
        
        
        #return True

###### Auxiliar functions #####

    #devolve o produto cartesiano
def get_cart_prd(pools):
        result = [[]]
        for pool in pools:
            result = [x+[y] for x in result for y in pool]
        return result

