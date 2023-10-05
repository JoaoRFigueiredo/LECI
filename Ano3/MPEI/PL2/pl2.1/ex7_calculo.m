N = 1e5;
seq = randi([1 3],2,N);


        
%alinea d - P[“seq inclui um” | “seq inclui dois”]
%P[“seq inclui um” e "seq inclui dois"]/P["seq inclui dois"]
countx = 0;
county = 0;
for m=1:N
    if ((seq(1, m)==1 && seq(2, m)==2) || (seq(1, m)==2 && seq(2, m)==1))
        countx = countx + 1;
    end
end

for n=1:N
    if (seq(1, n)==2 || seq(2, n)==2)
        county = county + 1;
    end
end

pUmDois = countx/N
pDois = county/N

pCondicional = pUmDois/pDois