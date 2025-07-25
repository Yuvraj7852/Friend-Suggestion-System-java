
import java.util.ArrayList;
import java.util.*;


class Friend_suggestion_graph{
           
           
 public static void main(String[] args) {
        
         int total_user=5;
            ArrayList<ArrayList<Integer>> graph = new  ArrayList<>();

            for(int i=0; i<total_user; i++){
                graph.add(new ArrayList<>());
            }

            Map<Integer, String> name = new HashMap<>();
            name.put(0, "yuvraj");
            name.put(1,"tanay");
            name.put(2, "santosh");
            name.put(3,"raj");
            name.put(4,"vinod");

  
            addEdge(graph,0,1);
            addEdge(graph,0,2);
            addEdge(graph,1,3);
            addEdge(graph,2,4);
            
            for (int i = 0; i < total_user; i++) {
                
            
        List<Integer> sugestion=suggestFrinde(graph, i);
        System.out.print("Friend Suggestion for "+ name.get(i) + ": ");
        if(sugestion.isEmpty()){
            System.out.println("No suggestions");
        }
        else{
            for(int id : sugestion){
                System.out.print(name.get(id) + " ");
            } 
            System.out.println("." );  }
            }
       
        
    }


    static void addEdge(ArrayList<ArrayList<Integer>>graph,int u, int v){
       graph.get(u).add(v);
       graph.get(v).add(u);


    }

    static List<Integer> suggestFrinde(ArrayList<ArrayList<Integer>>graph, int user){
        List<Integer>direct=graph.get(user);
        Set <Integer>suggestions=new HashSet<>();
        for(int friend : direct){
            for(int friend0friend : graph.get(friend)){
                if(friend0friend!=user&& ! direct.contains(friend0friend)){
                    suggestions.add(friend0friend);
                }
            }
        }

        return new ArrayList<>(suggestions);

    }
}