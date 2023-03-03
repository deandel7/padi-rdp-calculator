import java.util.*;
import java.util.Scanner;
public class padi {
    static char pressureGroup3;
    static char pressureGroup2;
    static char pressureGroup4;

    static void invert(Double[] arr) { // methods used to manipulate and sort arrays, find indexes, maxes.
        for(int i = 0; i < arr.length / 2; i++) {
            double temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    static void invert(Integer[] arr) { // inverts array
        for(int i = 0; i < arr.length / 2; i++) {
        int temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
        }
    }

    public static int getIntMax(Integer[] arr) { // gets max value of Integer array
        int maxValue = arr[0];
        for(int i=1;i < arr.length;i++) {
            if(arr[i] > maxValue){
            maxValue = arr[i];
            }
        } return maxValue;
    }

    public static double getMax(Double[] arr) { // gets max value of Double array
        double maxValue = arr[0];
        for(int i=1;i < arr.length;i++){
            if(arr[i] > maxValue){
            maxValue = arr[i];
        }
        } return maxValue;
    }

    public static char getMax(char[] arr) { // gets max value of char array
        char maxValue = arr[0];
        for(int i=1;i < arr.length;i++){
            if(arr[i] > maxValue){
            maxValue = arr[i];
        }
        } return maxValue;
    }

    public static int findIndex(Integer arr[], int a) { // following three methods finds index of an element
        int index1 = Arrays.binarySearch(arr, a);
        return(index1 < 0) ? -1 : index1;
    }

    public static int intFindIndex(Integer arr[], int a) {
        if(arr == null) {
            return -1;
        }
        int length = arr.length;
        int i = 0;
        while (i < length) {
            if(arr[i] == a) {
                return i;
            } else {
                i = i + 1;
            }
        } return -1;
    }
    
public static int charFindIndex(char arr[], char a) {
if(arr == null) {
return -1;
}
int lengt = arr.length;
int i = 0;
while(i < lengt) {
if(arr[i] == a) {
return i;
} else {
i = i + 1;
}
} return -1;
}
public static int doubleFindIndex(Double arr[], double a)
{
if(arr == null) {
return -1;
}
int length = arr.length;
int i = 0;
while (i < length) {
if (arr[i] == a) {
return i;
} else {
i = i + 1;
}
} return -1;
}
static void bubbleSort(Integer arr[], int a) // these two methods are bubble sorting for Integer array, Double array
{
int i, b, temp;
boolean swapped;
for (i = 0; i < a - 1; i++) {
swapped = false;
for (b = 0; b < a - i - 1; b++) {
if (arr[b] > arr[b + 1]) {

temp = arr[b];
arr[b] = arr[b + 1];
arr[b + 1] = temp;
swapped = true;
}
}
if(swapped == false)
break;
}
}
static void doubleBubbleSort(Double arr[], int a)
{
int i, b;
Double temp;
boolean swapped;
for (i = 0; i < a - 1; i++) {
swapped = false;
for (b = 0; b < a - i - 1; b++) {
if (arr[b] > arr[b + 1]) {
temp = arr[b];
arr[b] = arr[b + 1];
arr[b + 1] = temp;
swapped = true;
}
}
if (swapped == false)
break;
}
}
public static Integer[] addElement(int n, Integer arr[], int b) // method makes an arrayList of an array and adds an element to it (
{
int a;
List<Integer> arrlist
= new ArrayList<Integer>(
Arrays.asList(arr));
arrlist.add(b);
arr = arrlist.toArray(arr);
return arr;
}
public static Double[] doubleAddE(Double arr[], double x) // same as previous one but for Double array
{
List<Double> list = new ArrayList<Double>(Arrays.asList(arr));
list.add(x);
arr = list.toArray(arr);
return arr;
}
public static boolean checkForVal(Integer[] arr, int check) // checks Integer array for a specific value
{
boolean result = false;
for(int element : arr) {
if (element == check) {
result = true;
break;
}
} return result;
}
public static boolean checkDouble(Double[] arr, double check) // same as previous method but for Double array
{

boolean result = false;
for (double element : arr) {
if (element == check) {
result = true;
break;
}
} return result;
}
public static char getGroup(Integer[] arr, int minutes1, char[] groups) { // this method gets the pressure group after a single dive
int max = getIntMax(arr); // max element of array
int maxIndex = findIndex(arr, max); // index of the max element
int index1;
int n = 0;
char pressureGroup = 'A';
if(minutes1<=arr[0]) { // if input for minutes is too low, lowest minutes will be used
minutes1=arr[0];
index1 = findIndex(arr, minutes1);
pressureGroup = groups[index1];
} else if(minutes1>=arr[maxIndex]) { // if input for minutes is too high, highest minutes will be used
minutes1=arr[maxIndex];
index1 = findIndex(arr, minutes1);
pressureGroup = groups[index1];
} else if(checkForVal(arr, minutes1)==false) { // if the input for minutes is not in the array, this will round up the minutes
arr = addElement(maxIndex+1, arr, minutes1);
n = arr.length;
bubbleSort(arr, n);
index1=findIndex(arr, minutes1);
minutes1 = arr[index1 +1];
pressureGroup = groups[index1];
} else if(checkForVal(arr, minutes1)==true) { // if the input for minutes is in the array, the minutes will be used
index1 = findIndex(arr, minutes1);
pressureGroup = groups[index1];
}
System.out.println("minutes: " + minutes1);
System.out.println("group: " + pressureGroup);
pressureGroup2 = pressureGroup;
return pressureGroup2;
}
public static char getNewGroup(Double[] arr, char[] pressureGroup, double timeOut1) { // this method finds the new pressure group after waiting on the surface, timeOut is the time user says they waited
double max2 = getMax(arr);
int maxIndex1 = doubleFindIndex(arr, max2);
int m = 0;
int index3;
int index4;
int indexFound;
int indexOfInput = 0;
char pressureGroup1 = 'B';
int c = arr.length;
String finalTime;
if(timeOut1<=arr[arr.length-1]) { // if the user inputs a number too low, timeOut will be set to 0
timeOut1 = arr[arr.length-1];
int indexOf = doubleFindIndex(arr, timeOut1)/2; // since the array representations for times waited on the surface has two numbers per pressure Group, have to divide by 2
pressureGroup1 = pressureGroup[indexOf];
} else if(timeOut1>=arr[maxIndex1]) { // if the user inputs a number too high
timeOut1 = arr[maxIndex1];
pressureGroup1 = pressureGroup[maxIndex1];

} else if(checkDouble(arr, timeOut1)==false) { // if the user's minutes are not found on the table, have to make a new arraylist named copy, add the user's minutes, bubbleSort, and find the index
arr = doubleAddE(arr, timeOut1);
m = arr.length;
doubleBubbleSort(arr, m);
invert(arr);
indexOfInput = doubleFindIndex(arr, timeOut1);
Double[] copy = new Double[arr.length - 1];
for (int i = 0, j = 0; i < arr.length; i++) { // cycling through array and copying elements from it
if (i != indexOfInput) {
copy[j++] = arr[i];
}
}
index3 = indexOfInput-1;
timeOut1 = arr[index3];
index4 = doubleFindIndex(copy, timeOut1);
pressureGroup1 = pressureGroup[index4/2];
} else if(checkDouble(arr,timeOut1)==true) {
indexFound = doubleFindIndex(arr, timeOut1);
pressureGroup1 = pressureGroup[indexFound/2];
}
finalTime = String.valueOf(timeOut1);
finalTime = finalTime.replace('.', ':'); // since the array utilizes doubles instead of actual times, we have replace the period with a colon
System.out.println("time out of water: " + finalTime);
System.out.println("new group: " + pressureGroup1);
pressureGroup3 = pressureGroup1;
return pressureGroup3;
}
public static char getIntervalGroup(Integer[] arr, int minutes1, char[] groups) { // this method gets the group a diver must be in for a specified re-dive
int max = getIntMax(arr);
int maxIndex = intFindIndex(arr, max);
int index1;
int n = 0;
char pressureGroup = 'A';
if(minutes1<=arr[arr.length-1]) { // if input for minutes is too low
minutes1=arr[arr.length-1];
pressureGroup = groups[arr.length-1];
} else if(minutes1>=arr[0]) { // if input for minutes is too high
minutes1=arr[0];
pressureGroup = groups[0];
} else if(checkForVal(arr, minutes1)==false) { // if the input for minutes is not in the array, find element greater than it
arr = addElement(maxIndex+1, arr, minutes1);
n = arr.length;
bubbleSort(arr, n);
invert(arr);
index1=intFindIndex(arr, minutes1);
minutes1 = arr[index1 -1];
pressureGroup = groups[index1-1];
} else if(checkForVal(arr, minutes1)==true) { // if the input for minutes is in the array
index1 = intFindIndex(arr, minutes1);
pressureGroup = groups[index1];
}
System.out.println("group needed: " + pressureGroup);
pressureGroup4 = pressureGroup;
return pressureGroup4;
}

public static double findMinInterval(Double[] arr, int indexOfDesiredGroup) { // this method finds the minimum time we must wait to get a certain pressure group
double maximum = getMax(arr);
double minTime;
int indexOfMax = doubleFindIndex(arr, maximum);
if((indexOfDesiredGroup*2)+1 >= arr.length) { // if the desired pressure group index does not line up with current pressure group index on the table
minTime = arr[arr.length-1];
} else {
minTime = arr[(indexOfDesiredGroup*2)+1]; // have to multiply by 2 because the pressure groups have twice as little indexes as the waiting times, add by 1 to get the smaller of the two values in the range
}
String finalTime1 = String.valueOf(minTime);
finalTime1 = finalTime1.replace('.', ':'); // change doubles with periods to time
System.out.println("minimum time to wait: "+ finalTime1);
return minTime;
}
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
int depth1, depth=0;
int minutes;
Integer[] depths = {35,40,50,60,70,80,90,100,110,120,130,140}; // table 1 depths
Integer[] thirtyFive = {10,19,25,29,32,36,40,44,48,52,57,62,67,73,79,85,92,100,108,117,127,139,152,168,188,205}; // table 1 minutes under
Integer[] forty = {9,16,22,25,27,31,34,37,40,44,48,51,55,60,64,69,74,79,85,91,97,104,111,120,129,140};
Integer[] fifty = {7,13,17,19,21,24,26,28,31,33,36,39,41,44,47,50,53,57,60,63,67,71,75,80};
Integer[] sixty = {6,11,14,16,17,19,21,23,25,27,29,31,33,35,37,39,42,44,47,49,52,54,55};
Integer[] seventy = {5,9,12,13,15,16,18,19,21,22,24,26,27,29,31,33,35,36,38,40};
Integer[] eighty = {4,8,10,11,13,14,15,17,18,19,21,22,23,25,26,28,29,30};
Integer[] ninety = {4,7,9,10,11,12,13,15,16,17,18,19,21,22,23,24,25};
Integer[] oneHundred = {3,6,8,9,10,11,12,13,14,15,16,17,18,19,20};
Integer[] oneHundredTen = {3,6,7,8,9,10,11,12,13,13,14,15,16};
Integer[] oneHundredTwenty = {3,5,6,7,8,9,10,11,11,12,13};
Integer[] oneHundredThirty = {3,5,6,7,7,8,9,10};
Integer[] oneHundredFourty = {0,4,5,6,7,8};
char[] pressureGroups = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
Double[] groupZ = {6.00, 3.00, 2.59, 2.12,2.11,1.50,1.49,1.41,1.40,1.32,1.31,1.25,1.24,1.18,1.17,1.12,1.11,1.06,1.05, // table 2 surface times (backwards to line up parallel to pressureGroups char array
1.00,0.59,0.55,0.54,0.50,0.49,0.45,0.44,0.41,0.40,0.36,0.35,0.32,0.31,0.29,0.28,0.25,0.24,0.21,0.20,0.18,0.17,0.15,0.14,0.12,0.11,0.09,0.08,0.06,0.05,0.03,0.02,0.00};
Double[] groupY = {5.57,2.57,2.56,2.09,2.08,1.47,1.46,1.38,1.37,1.30,1.29,1.22,1.21,1.15,1.14,1.09,1.08,1.03,1.02,
0.57,0.56,0.52,0.51,0.47,0.46,0.42,0.41,0.38,0.37,0.34,0.33,0.30,0.29,0.26,0.25,0.22,0.21,0.19,0.18,0.15,0.14,0.12,0.11,0.09,0.08,0.06,0.05,0.03,0.02,0.00};
Double[] groupX = {5.54,2.54,2.53,2.06,2.05,1.44,1.43,1.35,1.34,1.27,1.26,1.19,1.18,1.12,1.11,1.06,1.05,1.00,0.59,
0.54,0.53,0.49,0.48,0.44,0.43,0.40,0.39,0.35,0.34,0.31,0.30,0.27,0.26,0.23,0.22,0.19,0.18,0.16,0.15,0.12,0.11,0.09,0.08,0.06,0.05,0.03,0.02,0.00};
Double[] groupW = {5.51,2.51,2.50,2.03,2.02,1.41,1.40,1.32,1.31,1.24,1.23,1.16,1.15,1.09,1.08,1.03,1.02,0.57,0.56,
0.51,0.50,0.46,0.45,0.41,0.40,0.37,0.36,0.32,0.31,0.28,0.27,0.24,0.23,0.20,0.19,0.16,0.15,0.13,0.12,0.09,0.08,0.06,0.05,0.03,0.02,0.00};
Double[] groupV = {5.48,2.48,2.47,2.00,1.59,1.38,1.37,1.29,1.28,1.21,1.20,1.13,1.12,1.06,1.05,1.00,0.59,0.54,0.53,
0.48,0.47,0.43,0.42,0.38,0.37,0.34,0.33,0.29,0.28,0.25,0.24,0.21,0.20,0.17,0.16,0.13,0.12,0.10,0.09,0.06,0.05,0.03,0.02,0.00};
Double[] groupU = {5.45,2.45,2.44,1.57,1.56,1.35,1.34,1.26,1.25,1.18,1.17,1.10,1.09,1.03,1.02,0.57,0.56,0.51,0.50,
0.45,0.44,0.40,0.39,0.35,0.34,0.30,0.29,0.26,0.25,0.22,0.21,0.18,0.17,0.14,0.13,0.10,0.09,0.07,0.06,0.03,0.02,0.00};
Double[] groupT = {5.42,2.42,2.41,1.54,1.53,1.32,1.31,1.23,1.22,1.14,1.13,1.07,1.06,1.00,0.59,0.54,0.53,0.48,0.47,
0.42,0.41,0.37,0.36,0.32,0.31,0.27,0.26,0.23,0.22,0.18,0.17,0.14,0.13,0.11,0.10,0.07,0.06,0.03,0.02,0.00};
Double[] groupS = {5.39,2.39,2.38,1.50,1.49,1.28,1.27,1.19,1.18,1.11,1.10,1.04,1.03,0.57,0.56,0.50,0.49,0.44,0.43,
0.39,0.38,0.33,0.32,0.28,0.27,0.24,0.23,0.19,0.18,0.15,0.14,0.11,0.10,0.07,0.06,0.04,0.03,0.00};
Double[] groupR = {5.35,2.35,2.34,1.47,1.46,1.25,1.24,1.16,1.15,1.08,1.07,1.00,0.59,0.53,0.52,0.47,0.46,0.41,0.40,
0.35,0.34,0.30,0.29,0.25,0.24,0.20,0.19,0.16,0.15,0.12,0.11,0.08,0.07,0.04,0.03,0.00};
Double[] groupQ = {5.31,2.31,2.30,1.43,1.42,1.21,1.20,1.12,1.11,1.04,1.03,0.56,0.55,0.49,0.48,0.43,0.42,0.37,0.36,
0.31,0.30,0.26,0.25,0.21,0.20,0.17,0.16,0.12,0.11,0.08,0.07,0.04,0.03,0.00};

Double[] groupP = {5.28,2.28,2.27,1.39,1.38,1.17,1.16,1.08,1.07,1.00,0.59,0.52,0.51,0.46,0.45,0.39,0.38,0.33,0.32,
0.28,0.27,0.22,0.21,0.17,0.16,0.13,0.12,0.08,0.07,0.04,0.03,0.00};
Double[] groupO = {5.24,2.24,2.23,1.35,1.34,1.13,1.12,1.04,1.03,0.56,0.55,0.48,0.47,0.42,0.41,0.35,0.34,0.29,0.28,
0.24,0.23,0.18,0.17,0.13,0.12,0.09,0.08,0.04,0.03,0.00};
Double[] groupN = {5.19,2.19,2.18,1.31,1.30,1.09,1.08,1.00,0.59,0.52,0.51,0.44,0.43,0.37,0.36,0.31,0.30,0.25,0.24,
0.19,0.18,0.14,0.13,0.09,0.08,0.04,0.03,0.00};
Double[] groupM = {5.15,2.15,2.14,1.26,1.25,1.05,1.04,0.56,0.55,0.47,0.46,0.40,0.39,0.33,0.32,0.26,0.25,0.20,0.19,
0.15,0.14,0.10,0.09,0.05,0.04,0.00};
Double[] groupL = {5.10,2.10,2.09,1.22,1.21,1.00,0.59,0.51,0.50,0.43,0.42,0.35,0.34,0.28,0.27,0.22,0.21,0.16,0.15,
0.10,0.09,0.05,0.04,0.00};
Double[] groupK = {5.05,2.05,2.04,1.17,1.16,0.55,0.54,0.46,0.45,0.38,0.37,0.30,0.29,0.23,0.22,0.17,0.16,0.11,0.10,
0.05,0.04,0.00};
Double[] groupJ = {5.00,2.00,1.59,1.12,1.11,0.50,0.49,0.41,0.40,0.32,0.31,0.25,0.24,0.18,0.17,0.12,0.11,0.06,0.05,
0.00};
Double[] groupI = {4.54,1.54,1.53,1.06,1.05,0.44,0.43,0.35,0.34,0.27,0.26,0.19,0.18,0.12,0.11,0.06,0.05,0.00};
Double[] groupH = {4.48,1.48,1.47,1.00,0.59,0.38,0.37,0.29,0.28,0.21,0.20,0.13,0.12,0.06,0.05,0.00};
Double[] groupG = {4.42,1.42,1.41,0.54,0.53,0.32,0.31,0.23,0.22,0.14,0.13,0.07,0.06,0.00};
Double[] groupF = {4.35,1.35,1.34,0.47,0.46,0.25,0.24,0.16,0.15,0.08,0.07,0.00};
Double[] groupE = {4.28,1.28,1.27,0.39,0.38,0.17,0.16,0.08,0.07,0.00};
Double[] groupD = {4.19,1.19,1.18,0.31,0.30,0.09,0.08,0.00};
Double[] groupC = {4.10,1.10,1.09,0.22,0.21,0.00};
Double[] groupB = {3.48,0.48,0.47,0.00};
Double[] groupA = {3.00,0.00};
char maxPressure;
int maxIndexDepths;
int maxIndexPressures;
int maxIndexDepthsInterval;
int max1;
int max3;
int maximumTime = 0;
int minutesOut1;
int minutesOut;
int STOP = 9999;
int nextDepth = 0;
int hours = 0;
String timeOut1 = "";
double timeOut = 0;
int residualNitrogen = 0;
char pressureGroupCounter;
System.out.print("Enter depth >> "); // determining depth and rounding up
depth1 = input.nextInt();
max1 = getIntMax(depths); // max element of array
maxIndexDepths = findIndex(depths, max1); // index of the max element
if(depth1<=depths[0]) { // adjusting user depth if too small
depth=depths[0];
}else if(depth1>=depths[maxIndexDepths]) { // adjusting user depth if too large
depth=depths[maxIndexDepths];
} else { // rounding up depths
double depth2 = depth1;
double depth3 = Math.ceil(depth2/10)*10;
depth=(int)depth3;
}
System.out.println("depth: "+ depth);
if(depth==35) {
maximumTime = thirtyFive[thirtyFive.length-1];
} else if(depth==40) {
maximumTime = forty[forty.length-1];

} else if(depth==50) {
maximumTime = fifty[fifty.length-1];
} else if(depth==60) {
maximumTime = sixty[sixty.length-1];
} else if(depth==70) {
maximumTime = seventy[seventy.length-1];
} else if(depth==80) {
maximumTime = eighty[eighty.length-1];
} else if(depth==90) {
maximumTime = ninety[ninety.length-1];
} else if(depth==100) {
maximumTime = oneHundred[oneHundred.length-1];
} else if(depth==110) {
maximumTime = oneHundredTen[oneHundredTen.length-1];
} else if(depth==120) {
maximumTime = oneHundredTwenty[oneHundredTwenty.length-1];
} else if(depth==130) {
maximumTime = oneHundredThirty[oneHundredThirty.length-1];
} else if(depth==140) {
maximumTime = oneHundredFourty[oneHundredFourty.length-1];
}
System.out.println("Maximum Time at " + depth + " feet: " + maximumTime);
System.out.print("Enter minutes in water >> ");
minutes = input.nextInt();
if(depth==depths[0]) { // get the first pressure group (single dive) based on the user's depth and feet input, uses the method getGroup
getGroup(thirtyFive, minutes, pressureGroups);
}
if(depth==depths[1]) {
getGroup(forty, minutes, pressureGroups);
}
if(depth==depths[2]) {
getGroup(fifty, minutes, pressureGroups);
}
if(depth==depths[3]) {
getGroup(sixty, minutes, pressureGroups);
}
if(depth==depths[4]) {
getGroup(seventy, minutes, pressureGroups);
}
if(depth==depths[5]) {
getGroup(eighty, minutes, pressureGroups);
}
if(depth==depths[6]) {
getGroup(ninety, minutes, pressureGroups);
}
if(depth==depths[7]) {
getGroup(oneHundred, minutes, pressureGroups);
}
if(depth==depths[8]) {
getGroup(oneHundredTen, minutes, pressureGroups);
}
if(depth==depths[9]) {
getGroup(oneHundredTwenty, minutes, pressureGroups);
}
if(depth==depths[10]) {
getGroup(oneHundredThirty, minutes, pressureGroups);
}
if(depth==depths[11]) {

getGroup(oneHundredFourty, minutes, pressureGroups);
}
System.out.print("Enter minutes out of water >> "); // surface interval code starts here
minutesOut1 = input.nextInt();
if(minutesOut1>=60) { // changing minutes out of water to hours
hours = minutesOut1/60;
minutesOut = minutesOut1%60;
if(minutesOut<10) {
timeOut1 = hours + ".0" + minutesOut;
} else if(minutesOut == 0){
timeOut1 = hours + ".00";
} else {
timeOut1 = hours + "." + minutesOut;
} timeOut = Double.parseDouble(timeOut1);
} else if(minutesOut1<60 && minutesOut1>=10) {
timeOut1 = "0." + minutesOut1;
timeOut = Double.parseDouble(timeOut1);
} else if(minutesOut1<10) {
timeOut1 = "0.0" + minutesOut1;
timeOut = Double.parseDouble(timeOut1);
}
if(pressureGroup2==pressureGroups[25]) { // finding new pressure group based on user's input for how long they waited and their pressure group, getNewGroup rounds the minutes accordingly
getNewGroup(groupZ, pressureGroups, timeOut);
} else if(pressureGroup2==pressureGroups[24]) {
getNewGroup(groupY, pressureGroups, timeOut);
} else if(pressureGroup2==pressureGroups[23]) {
getNewGroup(groupX, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[22]) {
getNewGroup(groupW, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[21]) {
getNewGroup(groupV, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[20]) {
getNewGroup(groupU, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[19]) {
getNewGroup(groupT, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[18]) {
getNewGroup(groupS, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[17]) {
getNewGroup(groupR, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[16]) {
getNewGroup(groupQ, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[15]) {
getNewGroup(groupP, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[14]) {
getNewGroup(groupO, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[13]) {
getNewGroup(groupN, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[12]) {
getNewGroup(groupM, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[11]) {
getNewGroup(groupL, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[10]) {
getNewGroup(groupK, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[9]) {
getNewGroup(groupJ, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[8]) {

getNewGroup(groupI, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[7]) {
getNewGroup(groupH, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[6]) {
getNewGroup(groupG, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[5]) {
getNewGroup(groupF, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[4]) {
getNewGroup(groupE, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[3]) {
getNewGroup(groupD, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[2]) {
getNewGroup(groupC, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[1]) {
getNewGroup(groupB, pressureGroups, timeOut);
}else if(pressureGroup2==pressureGroups[0]) {
getNewGroup(groupA, pressureGroups, timeOut);
}
// originally planned a while loop here to allow the user to keep calculating minimum surface intervals to plan their next dive
Integer[] depth35 = {195,186,180,176,173,169,165,161,157,153,148,143,138,132,126,120,113,105,97,88,78,66,53,37,17}; // table 3 repetitive dive timetable
Integer[] depth40 = {131,124,118,115,113,109,106,103,100,96,92,89,85,80,76,71,66,61,55,49,43,36,29,20,11};
Integer[] depth50 = {73,67,63,61,59,56,54,52,49,47,44,42,39,36,33,30,27,23,20,17,13,9,5};
Integer[] depth60 = {49,44,41,39,38,36,34,32,30,28,26,24,22,20,18,16,13,11,8,6,3,1};
Integer[] depth70 = {35,31,28,27,25,24,22,21,19,18,16,14,13,11,9,7,6,4,2};
Integer[] depth80 = {26,22,20,19,17,16,15,13,12,11,9,8,7,5,4,2};
Integer[] depth90 = {21,18,16,15,14,13,12,10,9,8,7,6,4,3,2};
Integer[] depth100 = {17,14,12,11,10,9,8,7,6,5,4,3,2};
Integer[] depth110 = {13,10,9,8,7,6,5,4,3,2,2};
Integer[] depth120 = {10,8,7,6,5,4,3,2};
Integer[] depth130 = {7,5,4,3};
Integer[] depthsInterval = {35,40,50,60,70,80,90,100,110,120,130}; // have to use new array for depths because 140 feet no longer used in this table
int response1 = 0;
System.out.print("Enter(1) to make another dive or (2) to calculate min. surface interval or (999) to quit >> ");
response1 = input.nextInt();
while(response1!=999) {
if(response1==1) {
int indexRepeat = charFindIndex(pressureGroups, pressureGroup3);
System.out.print("Enter dive depth >> ");
int repeatDepth = input.nextInt();
Integer[] copyOfArr = {};
int max4 = getIntMax(depths); // max element of array
maxIndexDepths = findIndex(depths, max4); // index of the max element
if(repeatDepth<=depths[0]) { // same code as before, adjusting if user depth input is too low, high, or needs to be rounded
repeatDepth=depths[0];
}else if(repeatDepth>=depths[maxIndexDepths]) {
repeatDepth=depths[maxIndexDepths];
} else {
double depth6 = repeatDepth;
double depth7 = Math.ceil(depth6/10)*10;
repeatDepth=(int)depth7;
}
if(repeatDepth==35) {
residualNitrogen = thirtyFive[indexRepeat];
} else if(repeatDepth==40) {
residualNitrogen = forty[indexRepeat];
} else if(repeatDepth==50) {

residualNitrogen = fifty[indexRepeat];
} else if(repeatDepth==60) {
residualNitrogen = sixty[indexRepeat];
} else if(repeatDepth==70) {
residualNitrogen = seventy[indexRepeat];
} else if(repeatDepth==80) {
residualNitrogen = eighty[indexRepeat];
} else if(repeatDepth==90) {
residualNitrogen = ninety[indexRepeat];
} else if(repeatDepth==100) {
residualNitrogen = oneHundred[indexRepeat];
} else if(repeatDepth==110) {
residualNitrogen = oneHundredTen[indexRepeat];
} else if(repeatDepth==120) {
residualNitrogen = oneHundredTwenty[indexRepeat];
} else if(repeatDepth==130) {
residualNitrogen = oneHundredThirty[indexRepeat];
} else if(repeatDepth==140) {
residualNitrogen = oneHundredFourty[indexRepeat];
}
System.out.print("Enter diving time (minutes) >> ");
int actualTime = input.nextInt();
int totalBottomTime = residualNitrogen+actualTime;
System.out.println("residual Nitrogen = " + residualNitrogen + ". actual bottom time = " + actualTime + ". total bottom time = "+ totalBottomTime);
if(repeatDepth==35) {
getGroup(thirtyFive, totalBottomTime, pressureGroups);
} else if(repeatDepth==40) {
getGroup(forty, totalBottomTime, pressureGroups);
} else if(repeatDepth==50) {
getGroup(fifty, totalBottomTime, pressureGroups);
} else if(repeatDepth==60) {
getGroup(sixty, totalBottomTime, pressureGroups);
} else if(repeatDepth==70) {
getGroup(seventy, totalBottomTime, pressureGroups);
} else if(repeatDepth==80) {
getGroup(eighty, totalBottomTime, pressureGroups);
} else if(repeatDepth==90) {
getGroup(ninety, totalBottomTime, pressureGroups);
} else if(repeatDepth==100) {
getGroup(oneHundred, totalBottomTime, pressureGroups);
} else if(repeatDepth==110) {
getGroup(oneHundredTen, totalBottomTime, pressureGroups);
} else if(repeatDepth==120) {
getGroup(oneHundredTwenty, totalBottomTime, pressureGroups);
} else if(repeatDepth==130) {
getGroup(oneHundredThirty, totalBottomTime, pressureGroups);
} else if(repeatDepth==140) {
getGroup(oneHundredFourty, totalBottomTime, pressureGroups);
}
}
if(response1==2) {
System.out.println("Enter next dive's depth for min. surface interval: ");
nextDepth = input.nextInt();
max3 = getIntMax(depthsInterval); // max element of array
maxIndexDepthsInterval = findIndex(depthsInterval, max3); // index of the max element
if(nextDepth<=depthsInterval[0]) { // same code as before, adjusting if user depth input is too low, high, or needs to be rounded
nextDepth=depthsInterval[0];

}else if(nextDepth>=depthsInterval[maxIndexDepthsInterval]) {
nextDepth=depths[maxIndexDepthsInterval];
} else {
double depth4 = nextDepth;
double depth5 = Math.ceil(depth4/10)*10;
nextDepth=(int)depth5;
}
System.out.println("Enter next dive's time for min. surface interval: ");
int nextTime = input.nextInt();
if(nextDepth==35) { // determining what pressure group we want based on user input for depth and time
getIntervalGroup(depth35, nextTime, pressureGroups);
} else if(nextDepth==40) {
getIntervalGroup(depth40, nextTime, pressureGroups);
} else if(nextDepth==50) {
getIntervalGroup(depth50, nextTime, pressureGroups);
} else if(nextDepth==60) {
getIntervalGroup(depth60, nextTime, pressureGroups);
} else if(nextDepth==70) {
getIntervalGroup(depth70, nextTime, pressureGroups);
} else if(nextDepth==80) {
getIntervalGroup(depth80, nextTime, pressureGroups);
} else if(nextDepth==90) {
getIntervalGroup(depth90, nextTime, pressureGroups);
} else if(nextDepth==100) {
getIntervalGroup(depth100, nextTime, pressureGroups);
} else if(nextDepth==110) {
getIntervalGroup(depth110, nextTime, pressureGroups);
} else if(nextDepth==120) {
getIntervalGroup(depth120, nextTime, pressureGroups);
} else if(nextDepth==130) {
getIntervalGroup(depth130, nextTime, pressureGroups);
}
int indexDesiredGroup = charFindIndex(pressureGroups, pressureGroup4);// pressureGroup3 is the current pressure group user is in, pressure Group4 is the one we need to be in)
if(pressureGroup3=='A') { // finding minimum time needed to wait to achieve desired pressureGroup
findMinInterval(groupA, indexDesiredGroup);
} else if(pressureGroup3 == 'B') {
findMinInterval(groupB, indexDesiredGroup);
} else if(pressureGroup3 == 'C') {
findMinInterval(groupC, indexDesiredGroup);
} else if(pressureGroup3 == 'D') {
findMinInterval(groupD, indexDesiredGroup);
} else if(pressureGroup3 == 'E') {
findMinInterval(groupE, indexDesiredGroup);
} else if(pressureGroup3 == 'F') {
findMinInterval(groupF, indexDesiredGroup);
} else if(pressureGroup3 == 'G') {
findMinInterval(groupG, indexDesiredGroup);
} else if(pressureGroup3 == 'H') {
findMinInterval(groupH, indexDesiredGroup);
} else if(pressureGroup3 == 'I') {
findMinInterval(groupI, indexDesiredGroup);
} else if(pressureGroup3 == 'J') {
findMinInterval(groupJ, indexDesiredGroup);
} else if(pressureGroup3 == 'K') {
findMinInterval(groupK, indexDesiredGroup);
} else if(pressureGroup3 == 'L') {
findMinInterval(groupL, indexDesiredGroup);

} else if(pressureGroup3 == 'M') {
findMinInterval(groupM, indexDesiredGroup);
} else if(pressureGroup3 == 'N') {
findMinInterval(groupN, indexDesiredGroup);
} else if(pressureGroup3 == 'O') {
findMinInterval(groupO, indexDesiredGroup);
} else if(pressureGroup3 == 'P') {
findMinInterval(groupP, indexDesiredGroup);
} else if(pressureGroup3 == 'Q') {
findMinInterval(groupQ, indexDesiredGroup);
} else if(pressureGroup3 == 'R') {
findMinInterval(groupR, indexDesiredGroup);
} else if(pressureGroup3 == 'S') {
findMinInterval(groupS, indexDesiredGroup);
} else if(pressureGroup3 == 'T') {
findMinInterval(groupT, indexDesiredGroup);
} else if(pressureGroup3 == 'U') {
findMinInterval(groupU, indexDesiredGroup);
} else if(pressureGroup3 == 'V') {
findMinInterval(groupV, indexDesiredGroup);
} else if(pressureGroup3 == 'W') {
findMinInterval(groupW, indexDesiredGroup);
} else if(pressureGroup3 == 'X') {
findMinInterval(groupX, indexDesiredGroup);
} else if(pressureGroup3 == 'Y') {
findMinInterval(groupY, indexDesiredGroup);
} else if(pressureGroup3 == 'Z') {
findMinInterval(groupZ, indexDesiredGroup);
}
} System.out.print("Enter(1) to make another dive or (2) to calculate min. surface interval or (999) to quit >> ");
response1 = input.nextInt();
}
}
}