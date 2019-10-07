package com;




class MyData {
   volatile int number = 0;

    public void addT060() {
        this.number = 60;
  }
  public void  add(){
            number++;

  }

}
//验证  
public class VolatileDemo {

    public static void main(String[] args) {

        MyData myData = new MyData();
        for (int i = 0; i <1000 ; i++) {
                  myData.add();

            System.out.println(myData.number);

        }        
        
    }
}
