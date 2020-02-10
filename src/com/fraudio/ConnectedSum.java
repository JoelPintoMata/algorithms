package com.fraudio;

public class ConnectedSum {

    /**
     *
     * @param a
     */
//    public static void main(String[] a) {
//        ConnectedSum combinationSumIV = new ConnectedSum();
//        List<String> list = new ArrayList<>();
//        list.add("8 1");
//        list.add("5 8");
//        list.add("7 3");
//        list.add("8 6");
//        System.out.println(combinationSumIV.connectedSum(8, list));
////        list = new ArrayList<>();
////        list.add("1 2");
////        list.add("1 3");
////        list.add("2 4");
////        list.add("3 5");
////        list.add("7 8");
////        System.out.println(combinationSumIV.connectedSum(10, list));
////        list = new ArrayList<>();
////        list.add("1 2");
////        list.add("1 4");
////        System.out.println(combinationSumIV.connectedSum(4, list));
//    }
//
//    public int connectedSum(int n, List<String> edges) {
//        int arr[][] = new int[n][n];
////        init the graph array map
//        for (int i=0; i<n; i++) {
//            arr[i][i] = 1;
//        }
//
////        count nodes without edges
//        Set<Integer> edgesReported = new HashSet<>();
//        for (int i=0; i<edges.size(); i++) {
//            String[] node = edges.get(i).split(" ");
//            arr[Integer.parseInt(node[0])-1][Integer.parseInt(node[1])-1] = 1;
//            edgesReported.add(Integer.parseInt(node[0])-1);
//            edgesReported.add(Integer.parseInt(node[1])-1);
//        }
//
////        mapping the graph to an array
//        for (int i=0; i<edges.size(); i++) {
//            String[] node = edges.get(i).split(" ");
//            arr[Integer.parseInt(node[0])-1][Integer.parseInt(node[1])-1] = 1;
//        }
//
////        find isolated graphs
//        List<Integer> visitedRoots = new ArrayList<>();
//        Double totalResult = 0D;
//        for (int i=0; i<n; i++) {
//            if (visitedRoots.contains(i)) {
//                continue;
//            }
//            int count = 1;
//            Stack<Integer> stack = new Stack();
//            stack.push(i);
//            int visitedNodes[][] = new int[arr.length][arr.length];
//            while(!stack.empty()) {
//                int node = stack.pop();
//                visitedRoots.add(node);
//                for (int j=0; j < arr.length; j++) {
//                    if(node == j)
//                        continue;
//                    if(visitedNodes[node][j] > 0)
//                        continue;
//                    if (arr[node][j] > 0) {
//                        stack.push(j);
//                        count++;
//                    }
//                    visitedNodes[node][j] = 1;
//                }
//            }
//            double thisResult = count > 1 ? Math.ceil(Math.sqrt(count)) : 1;
//            if(thisResult > 1)
//                totalResult = totalResult + thisResult;
//        }
//        return totalResult.intValue() + (n - edgesReported.size());
//    }
//
//
//
//    public void genMessageChunks(String message) {
//        String arr[] = message.split(" ");
//        int chunkSize = 30;
//        int contentSize = 24;
//        int suffixSize = 6;
//        StringBuilder chunk = new StringBuilder();
//        List<String> chunkList = new ArrayList<>(9);
////         get the list of chunks
//        for(int i=0; i<arr.length; i++) {
//            String word = arr[i];
//            if(chunk.length()+ word.length() < 24) {
//                chunk.append(word);
//            } else {
//                chunkList.add(chunk);
//                chunk = new StringBuilder();
//            }
//        }
////         add suffix information to each chunk
//        String suffix = "";
//        for(int i=0; i<chunkList.size(); i++) {
//            chunk = new StringBuilder(chunkListget(i));
//            suffix = String.format(" (%s/%s)", i, chunkList.size());
//            chunk.append(suffix);
//            System.out.println(chunk.toString());
//        }
//    }
}