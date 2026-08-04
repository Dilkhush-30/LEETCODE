class Solution {
    public String maskPII(String s) {
        int at =s.indexOf('@');
        if(at>0){
            StringBuilder sb = new StringBuilder();

            char first = s.charAt(0);
            if(first >= 'A' && first <= 'Z'){
                first = (char)(first+ 32);
            }
            sb.append(first);
            sb.append("*****");

            char last = s.charAt(at - 1);
            if(last >= 'A' && last <= 'Z'){
                last = (char)(last + 32);
            }
            sb.append(last);

            for(int i = at; i < s.length(); i++){
                char c = s.charAt(i);
                if(c >= 'A' && c <= 'Z'){
                    c = (char)(c + 32);
                }
                sb.append(c);
            }
            return sb.toString();
        }
        int digitCount = 0;
        char[] lastFour = new char[4];

        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                if(digitCount < 4){
                    lastFour[3 - digitCount] = c;
                }
                digitCount++;
            }
        }

        StringBuilder result = new StringBuilder();
        int countryDigits = digitCount - 10;

        if(countryDigits > 0){
            result.append('+');
            for(int i =0; i < countryDigits; i++){
                result.append('*');
            }
            result.append('-');
        }
        result.append("***-***-");
        for(int i = 0; i < 4; i++){
            result.append(lastFour[i]);
        }
        return result.toString();
    }
}