package coding.dsa;


public class ConcentricLayers {
        public static void main(String[] args) {
            int n = 3;
            printConcentricLayers(n);
        }
        private  static void printConcentricLayers(int n){

            int size = 2*n-1;
            int[][] result= new int[size][size];
            for(int i = 0 ; i < size; i++){

                for(int j = 0 ; j < size; j++){
                    if(i==0 || i==size){
                        result[i][j]= n;
                    }
                    else if(j==0 || j==size){
                        result[i][j]= n;
                    }
                    else {
                        n-=1;
                        result[i][j]=n;
                    }
                }

            }

            System.out.println(result);

        }

}
