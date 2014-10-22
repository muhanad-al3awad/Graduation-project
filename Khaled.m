clc                                    % Clear Command Window
No_Nodes = 51;                        % Number of Nodes in The Network
figure(1);
clf;                                   % Clear Current Figure Window
hold on;                               % The hold on command tells Matlab to hold the plot, so that when I do the next plot commands it keeps my original sine curve on there
S = 100;                               % Size of Network
No_Levels=5;
Net_Xloc = rand( 1 , No_Nodes) * S;    % Generate Matrix for X Location of Nodes Randomly   
Net_Yloc = rand( 1, No_Nodes) * S;    % Generate Matrix for Y Location of Nodes Randomly
Net_Xloc(1) =1;
Net_Yloc(1) =50;
plot( Net_Xloc(1), Net_Yloc(1), 'X');
Distance = zeros( No_Nodes, No_Nodes );% Declaration of Distance Matrix
Energy = zeros (1 , No_Nodes );
HopTree= zeros (1 , No_Nodes);
Tree= zeros(No_Nodes, No_Levels);
Visited= zeros(1,No_Nodes);
Nodes= zeros(No_Nodes,4 );
Min_Nodes=zeros(No_Nodes, No_Levels);
A = zeros ( No_Nodes , 3 );

for i = 1: No_Nodes
    % Plot The Network
    plot( Net_Xloc(i), Net_Yloc(i), '.');
    % Write Number of Node Next to '.'
   text( Net_Xloc(i), Net_Yloc(i), num2str(i));
    Energy (i) = randi([3 , 5]) ;      % Generate random number in specific range from --- to --- as you like
    for j = 1 : No_Nodes
        % Calculate The Distance Between Nodes
        Distance(i,j) = sqrt(( Net_Xloc(i) - Net_Xloc(j) )^2 + ( Net_Yloc(i) - Net_Yloc (j) )^2 );
        
    end
    Nodes(i,1)= Net_Xloc(i);
    Nodes(i,2)= Net_Yloc(i);
    Nodes(i,3)= Energy(i);
    Nodes(i,4)= Distance(1,i);
    % Write Details of your Network in Excel File to Use it Later (if you Want to Worked on Fixed Network )
    
    A (  i , 1 ) =  Net_Xloc(i);
    A (  i , 2 ) =  Net_Yloc(i);
    A (  i , 3 ) =  Energy (i);  
end
Root= 9999999999999999999999;
Min_Dis=Distance(1,2);
for i=2:No_Nodes
   if(Nodes(i,4)<Min_Dis)
       Min_Dis=Nodes(i,4);
       Root=i;
   end
end


Visited(1,Root)=Root;
Visited(1)=1;

for i=2:No_Nodes
   Visited(i)=0;
    for j=1:No_Levels
       [dist ind]=getNElements(Distance(i,:),No_Nodes);
       k=1;
       w=1;
       while(ismember(0,Min_Nodes(i,:)))
          if(ismember(ind(k),Visited))
             k=k+1; 
          
          else
             Min_Nodes(i,w)=ind(k);
             Visited(ind(k))=ind(k);
             w=w+1;
             k=k+1;
              
          end
           
       end
       
    end
    
end





% for i=1: No_Nodes
%     %hop tree
%    HopTree(i)= sqrt(( Net_Xloc(i) - Net_Xloc(1) )^2 + ( Net_Yloc(i) - Net_Yloc (1) )^2 );
%    text( Net_Xloc(i), Net_Yloc(i), num2str(HopTree(i)));
%     
%     
% end
% for i=2: No_Nodes
%    for j= 1: No_Levels
%       Tree(i,j)= 
%        
%    end
%     
% end

% File_Name = 'Fixed Network.xlsx';
% Sheet = 1;
% xlswrite( File_Name , A , Sheet ); 
% % Read From Excel File to Use it (if you Want )
% A = xlsread(File_Name , 1 );