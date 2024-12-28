import java.util.Scanner;

class SubArraySum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        int sum =0;
        for(int i =0; i < n; i++){
            sum += arr[i];
        }
        int i =0;
        int j = k-1;
        while(j < n){
            System.out.println(sum);
            j++;
            if(j < n){
                sum += arr[j];
            }
            sum -= arr[i];
            i++;
        }
        
    }
}