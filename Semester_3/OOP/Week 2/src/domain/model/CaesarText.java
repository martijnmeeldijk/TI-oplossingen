package domain.model;

public class CaesarText implements Encryptor, Decryptor{

    int shift = 7;

    public void CaesarText(){ }

    public void setShitft(int shitft) {
        this.shift = shitft;
    }

    @Override
    public String encrypt(String inputString) {
        String s = "";
        int len = inputString.length();
        for(int x = 0; x < len; x++){
            char c = (char)(inputString.charAt(x) + shift);
            if (c > 'z')
                s += (char)(inputString.charAt(x) - (26-shift));
            else
                s += (char)(inputString.charAt(x) + shift);
        }
        return s;
    }

    @Override
    public String decrypt(String inputString) {
        StringBuilder temp = new StringBuilder();

        for(int i=0; i<inputString.length(); i++) {
            char c = (char)(inputString.charAt(i) - 3);

            if(c > 'x') {
                c = (char)(inputString.charAt(i) + 26);
            } else {
                c = (char)(inputString.charAt(i) - 3);
            }

            temp.append(c);
        }

        return temp.toString();
    }


}
