import java.util.Scanner;

public class Front {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sequence = scan.nextLine();
        sequence = sequence.toUpperCase();
        String complement = DNAtools.toComplement(sequence);
        String mRNA = DNAtools.toMRNA(sequence);
        String protein = DNAtools.toProtein(sequence);
        System.out.println(DNAtools.toTriplicate(sequence));
        System.out.println(DNAtools.toTriplicate(complement));
        System.out.println(DNAtools.toTriplicate((mRNA)));
        System.out.println(protein);
        scan.close();
    }
}