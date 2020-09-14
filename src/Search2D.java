import java.util.*;
public class Search2D {

  // defines:
  //    String[][] names
  //    Double[][] coordinates
  //    Integer[][] coordinates_int

  
  public static void main(String[] args) {
    String x = "17.43";
    String y = "22.84121";
    // x < y 
    System.out.println(x.compareTo(y)<0);
    System.out.println(y.compareTo(x)>0);
    System.out.println(y.compareTo("22.84121")==0);

      String[][] names = {{"Dan","DeBlasio"}};
      
      Double[][] coordinates = 
        {
          {31.8334, -106.4405},
          {31.7816, -106.4496},
          {31.8093, -106.4782},
          {31.7563, -106.4766},
          {31.7572, -106.4887},
          {31.7368, -106.4730},
          {31.7442, -106.4861},
          {31.7707, -106.5051}
        };
      
      Integer[][] coordinates_int = 
        {
          {318334, -1064405},
          {317816, -1064496},
          {318093, -1064782},
          {317563, -1064766},
          {317572, -1064887},
          {317368, -1064730},
          {317442, -1064861},
          {317707, -1065051}
        };
    
    System.out.println(linearSearch2D(names, "Corbin"));
    System.out.println(linearSearch2D(coordinates, 31.7707));
    System.out.println(linearSearch2D(coordinates_int, 317707));
    

    System.out.println(linearSearch2D(coordinates, 31., 1));
    System.out.println(linearSearch2D(coordinates_int, 310000, 10000));
    
    printRange(names, 6, 8, 0, 1);
    printRange(coordinates, 6, 8, -4, 1);
    printRange(coordinates_int, 6, 8, 0, 1);
  }

  // needs to have a compareTo(G anotherObject) as a method
  public static <G extends Comparable<G>> boolean linearSearch2D(G[][] inArray, G search) {
    // returns true if any element of the array is equal to the search string
    System.out.println("Running linearSearch2D with G as " + search.getClass().toString());
    for(int i=0; i<inArray.length; i++) {
      for(int j=0; j<inArray[i].length; j++) {
        if(inArray[i][j].compareTo(search) == 0) {
          return true;
        }
      }
    }
    return false;
  }
  

 // Number includes all the stuff from Comparable as well
 public static <G extends Number, S extends Number, P extends Number> boolean linearSearch2D(G[][] inArray, S search, P precision) {
   // returns true if any element of the array is equal to the search string
   System.out.println("Running linearSearch2D with G as " + inArray[0][0].getClass().toString());
   System.out.println("Running linearSearch2D with S as " + search.getClass().toString());
   System.out.println("Running linearSearch2D with P as " + precision.getClass().toString());
   for(int i=0; i<inArray.length; i++) {
     for(int j=0; j<inArray[i].length; j++) {
       if(Math.abs(inArray[i][j].floatValue() - search.floatValue()) < precision.floatValue()) {
         return true;
       }
     }
   }
   return false;
 }
 
 public static <G> void printRange(G[][] inArray, int iMin, int iMax, int jMin, int jMax) {
   for(int i=iMin; i<=iMax; i++) {
     for(int j=jMin; j<=jMax; j++) {
       // if i or j are out of bounds, don't print anything
       if(i<inArray.length && j<inArray[i].length && i>=0 && j>=0) {
         System.out.print(inArray[i][j] + "\t");
       }
     }
     System.out.println();
   }
 }
}
