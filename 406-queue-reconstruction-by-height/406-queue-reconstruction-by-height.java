class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
    Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
	List<int[]> ordered = new LinkedList<>();
       
	for (int[] p: people){
        // System.out.print(p[0] + " " + p[1] + " , ");
        ordered.add(p[1], p);
        int[][] ans = ordered.toArray(new int[people.length][2]);
        // System.out.println(Arrays.deepToString(ans));
    } 
	return ordered.toArray(new int[people.length][2]);
    }
}


///[[7,0],[4,4],[7,1],[6,1],[5,0],[6,1],[5,2]]

// sort a[0] --> 4,4  5,0  5,2  6,1  7,0  7,1
// sort a[1] --> 7,0  5,0  7,1  6,1  5,2  4,4

//  5,0  7,0  5,2  6,1  4,4  7,1


//   0 0 1 1 2 2 4 5

//setAtIndex
//insertAtIndex  - ye kr rhe h

// 7 0 , [[7, 0], null, [0, 0], [0, 0], [0, 0], [0, 0]]
// 7 1 , [[7, 0], [7, 1], null, [0, 0], [0, 0], [0, 0]]
// 6 1 , [[7, 0], [6, 1], [7, 1], null, [0, 0], [0, 0]]
// 5 0 , [[5, 0], [7, 0], [6, 1], [7, 1], null, [0, 0]]
// 5 2 , [[5, 0], [7, 0], [5, 2], [6, 1], [7, 1], null]
// 4 4 , [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
