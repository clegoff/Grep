import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args[0].equals(null)) {
            throw new IllegalArgumentException("No argument");
        }

        File file = null;
        BufferedReader br = null;

        try {
            file = new File(args[0]);
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int[][] etat = new int[5][5];
        etat[0][0] = 0;
        etat[1][0] = 0;
        etat[2][0] = 0;
        etat[3][0] = 0;
        etat[4][0] = 1;
        etat[0][1] = 1;
        etat[1][2] = 2;
        etat[2][2] = 2;
        etat[2][3] = 3;
        etat[3][4] = 4;


        String line;
        Character[] charObjectArray;
        int etatActuel;
        int ln = 0;

        try {
            while ((line = br.readLine()) != null) {
                etatActuel = 0;
                charObjectArray = line.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
                for (char c : charObjectArray) {
                    ln++;
                    if (etatActuel == 0) {
                        if (c == 'S') {
                            etatActuel = 1;
                        }
                    } else if (etatActuel == 1) {
                        if (Character.isLetter(c) && ("" + c).equals(("" + c).toLowerCase())) {
                            etatActuel = 2;
                        } else {
                            etatActuel = 0;
                        }
                    } else if (etatActuel == 2) {
                        if (c == 'o') {
                            etatActuel = 3;
                        } else if (Character.isLetter(c) && ("" + c).equals(("" + c).toLowerCase())) {
                        } else {
                            etatActuel = 0;
                        }
                    } else if (etatActuel == 3) {
                        if (c == 'n') {
                            etatActuel = 4;
                        } else {
                            etatActuel = 0;
                        }
                    }
                    if (etatActuel == 4) {
                        System.out.println("Line " + ln + " : " + line);
                        System.out.println("---------------------");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}