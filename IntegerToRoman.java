public class IntegerToRoman {
    public static void main(String[] args) {
	int num = Integer.parseInt(args[0]);
        if(num == 0)return;
        String[] romanChar = {"I","V","X","L","C","D","M","_V","_X","_L","_C","_D","_M"};
        int[] romanVal = {1,5,10,50,100,500,1000,5000,10000,50000,100000,500000,1000000};
        String finalResult = "";
        while(num > 0){
            String res = "";
            int temp = (int)Math.pow(10,(int)Math.log10(num));
            int dig = num / temp;
            int val = dig * temp;
            if(dig == 4){
                for(int i = 0; i < romanVal.length - 1;i = i + 2){
                    if(romanVal[i + 1] - romanVal[i] == val){
			if(romanChar[i].equals("M"))res = res + "_I" + romanChar[i + 1];
			else res = res + romanChar[i] + romanChar[i + 1];
                        break;
                    }
                }
            }
            else if (dig == 9){
                for(int i = 0; i < romanVal.length - 2;i += 2){
                    if(romanVal[i + 2] - romanVal[i] == val){
			if(romanChar[i].equals("M"))res = res + "_I" + romanChar[i + 1];
			else res = res + romanChar[i] + romanChar[i + 2];
                        break;
                    }
                }
            }
            else {    
                int index = romanVal.length - 1;
                for(;index >= 0; index--){
                    if(val >= romanVal[index]){
                        break;
                    }
                }
                int remainingVal = val - romanVal[index];
                res = romanChar[index];
                if(remainingVal < romanVal[index])index--;
                for(int i = 0; i < remainingVal / temp;i++){
                    res = res + romanChar[index];
                }
                
            }
            System.out.println("Value : " + val + "," + res);
            finalResult += res;
            num = num % (dig * temp);
        }
        System.out.println(finalResult);        
    }
}
