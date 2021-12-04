public class Problems {

  // Problem 1. First non-repeating character
  public char FirstNon_repeatingCharacter(String s) {
    int count;

    for (int i = 0; i < s.length(); i++) {
      count = 0;
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j)) {
          count++;
        }
      }
      if (count == 0 || count % 2 != 0) {
        return s.charAt(i);
      }
    }
    return '_';
  }

  // Problem 2. Mirror Bits
  public int MirrorBits(int numbers) {
  int result = 0;
    while (numbers > 0) {
      result <<= 1;
      result |= numbers & 1;
      numbers >>= 1;
    }
    return result;
  }

  // Problem 3. Delete digit
  public int DeleteDigit(int numbers) {

    int min = numbers % 10;
    boolean target = false;

    int temp = numbers;
    int count = 1;

    while (numbers > 0) {
      if (min > numbers % 10) {
        min = numbers % 10;
      }
      numbers/=10;
    }

    while (temp > 0) {
      if (temp % 10 != min || target) {
        numbers += ( temp % 10 ) * count;
        count*=10;
      }
      if (temp % 10 == min){
        target = true;
      }
      temp /= 10;
    }

    return numbers;
  }

  // Problem 4. Line encoding
  public String LineEncoding(String s) {

    int number = 1;
    int index = 0;
    StringBuilder result = new StringBuilder();
    if (s.length() < 2) {
      return s;
    }
    for (; index < s.length() - 1; index++) {
      if (s.charAt(index) == s.charAt(index + 1)) {
        number++;
      } else {
        if (number > 1) {
          result.append(number).append(s.charAt(index));
          number = 1;
        } else {
          result.append(s.charAt(index));
        }
      }
      if (index == s.length() - 2) {
        if (number > 1) {
          result.append(number).append(s.charAt(index + 1));
        } else {
          result.append(s.charAt(index + 1));
        }
      }
    }
    return result.toString();
  }


}