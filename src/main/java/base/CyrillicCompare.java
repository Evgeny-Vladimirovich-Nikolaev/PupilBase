/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author Nobilis
 */
public class CyrillicCompare {
    int[] chArray;
    String first, second; 
    int strLength, strLength2, compareString, index1, index2, count;    
    public CyrillicCompare(String firstName, String secondName) {
        this.chArray = new int[]{-1, 48, -1, 49, -1, 50, -1, 51, -1, 52, -1, 53, 
            -1, 54, -1, 55, -1, 56, -1, 57, -1, 32, -1, 45, 1040, 1072, 1041, 
            1073, 1042, 1074, 1043, 1075, 1044, 1076, 1045, 1077, 1025, 1105, 
            1046, 1078, 1047, 1079, 1048, 1080, 1049, 1081, 1050, 1082, 1051, 
            1083, 1052, 1084, 1053, 1085, 1054, 1086, 1055, 1087, 1056, 1088, 
            1057, 1089, 1058, 1090, 1059, 1091, 1060, 1092, 1061, 1093, 1062, 
            1094, 1063, 1095, 1064, 1096, 1065, 1097, 1066, 1098, 1067, 1099, 
            1068, 1100, 1069, 1101, 1070, 1102, 1071, 1103};
        this.first = firstName;
        this.second = secondName;
        if(second.length()<first.length()){
            strLength=second.length();
            strLength2=first.length();
        }
        else {
            strLength=first.length();
            strLength2=second.length();
        }
        this.compareString=0;
        this.index1=this.index2=65536; 
        this.count=-1;
    }
    
   

    int caseSensitive(){
        while(count<strLength-1&&index1==index2){
            count++;
            int i=-1;
            int k=0;
            do  {i++;
                if(first.charAt(count)==chArray[i])
                   {index1=i;
                   k++;}
                if(second.charAt(count)==chArray[i])
                   {index2=i;
                   k++;}
            }while(k==0&i<chArray.length-1);
        }
        if(index1>index2)compareString=-1;
        else if (index1<index2)compareString=1;
        return compareString;
    }
    
    int caseInsensitive(){
        /*        
        int a=0;
        int[] str1= new int[strLength2];
        int[] str2= new int[strLength2];
        for(int m=0; m<strLength2; m++){
        str1[m]=0;
        str2[m]=0;
        }
        for(int i=0; i<strLength2; i++){
        for(int k=0; k<chArray.length; k++){
        if(first.length()>i&&first.charAt(i)==chArray[k])str1[i]=chArray[k];
        if(second.length()>i&&second.charAt(i)==chArray[k])str2[i]=chArray[k];
        }
        }
        while(compareString==0&a<strLength2){
        if(str1[a]<str2[2])compareString=1;
        if(str1[a]>str2[2])compareString=-1;
        a++;
        }
        */
        
        int a=0, b=0; 
        int[] str1= new int[strLength2];
        int[] str2= new int[strLength2];
        for(int m=0; m<strLength2; m++){
        str1[m]=0;
        str2[m]=0;
        }
        for(int i=0; i<strLength2; i++){
            for(int k=0; k<chArray.length; k++){
                if(first.length()>i&&first.charAt(i)==chArray[k]){
                    str1[a]=k/2;
                    a++;
                }
                if(second.length()>i&&second.charAt(i)==chArray[k]){
                    str2[b]=k/2;
                    b++;
                }
            }
        }
        a=0;
        while(compareString==0&a<strLength2){
        if(str1[a]<str2[a])compareString=1;
        if(str1[a]>str2[a])compareString=-1;
        a++;
        }
        return compareString;
    }
}
