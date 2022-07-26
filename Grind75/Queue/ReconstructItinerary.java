package Queue;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 *  reconstruct the itinerary in order.
 *
 *  All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 *  Note:
 *
 *      If there are multiple valid itineraries,
 *          you should return the itinerary that has the smallest lexical order when read as a single string.
 *          For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 *
 *      All airports are represented by three capital letters (IATA code).
 *
 *      You may assume all tickets form at least one valid itinerary.
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 *  Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 *
 *  Example 2:
 *
 *  Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 *  Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 *
 *  Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *                 But it is larger in lexical order.
 */
public class ReconstructItinerary {
    public static List<String> itinerary(List<List<String>> tickets){
        Map<String, PriorityQueue<String>> routes = new HashMap<>();
        for(List<String> ticket:tickets){
            if(!routes.containsKey(ticket.get(0)))
                routes.put(ticket.get(0), new PriorityQueue<>()); // lexicographic order so priority queue
            routes.get(ticket.get(0)).offer(ticket.get(1));
        }
        LinkedList<String> list = new LinkedList<>();
        dfs("JFK",routes,list);
        return  list;
    }
    public static void dfs(String from,Map<String,PriorityQueue<String>>routes,LinkedList<String>list){
        while(routes.containsKey(from) && !routes.get(from).isEmpty()){
            dfs(routes.get(from).poll(),routes,list);
        }
        list.addFirst(from);
    }

    public static void main(String[] args) {
        List<List<String >>tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC","LHR"));
        tickets.add(Arrays.asList("JFK","MUC"));
        tickets.add(Arrays.asList("SFO","SJC"));
        tickets.add(Arrays.asList("LHR","SFO"));
        System.out.println(itinerary(tickets));
    }

}
