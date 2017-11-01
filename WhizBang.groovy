class WhizBang {
  Long id
  String player
  int num1
  int num2
  String game


  public void validateNums(int num1, int num2) {
      int temp
      if (num1 > num2) {
          temp = num1
      		setNum1(num2)
          setNum2(temp)
      }
  }

  public String setGame(int num1, int num2) {
      String showWhizBang = " "
      for (int i = num1; i <= num2; i++) {
        if ( (i % 3 == 0) && (i % 5 == 0) )
            showWhizBang = showWhizBang + " " + "WhizBang"
        else {
          if  ( i % 5 == 0) {
            showWhizBang = showWhizBang + " " +  "Bang"
          }
          else {
            if (i % 3 == 0) {
              showWhizBang = showWhizBang + " " + "Whiz"
            }
            else {
              showWhizBang = showWhizBang + " " + i
            }
          }
        }
      }
      return showWhizBang
    }

}
