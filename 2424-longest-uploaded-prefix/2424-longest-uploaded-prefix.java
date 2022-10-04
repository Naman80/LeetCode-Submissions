class LUPrefix {

    boolean[] arr ;
    int i = 1;
    public LUPrefix(int n) {
        arr = new boolean[n+1];
    }
    
    public void upload(int video) {
        arr[video] = true;
        boolean check = false;
        for(int j = i ; j < arr.length;j++){
            if(arr[j]==false){
                i = j;
                break;
            }
            if(j == arr.length - 1)check =true;
        }
        if(check)i = arr.length;
        
    }
    
    public int longest() {
        return i-1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */