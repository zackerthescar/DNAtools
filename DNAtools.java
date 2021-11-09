import java.lang.StringBuilder;
import java.util.Dictionary;
import java.util.Hashtable;

public class DNAtools {
    public static String toComplement(String sequence){
        StringBuilder complement = new StringBuilder();
        int length = sequence.length();
        for (int i = 0; i < length; i++){
            switch(sequence.charAt(i)) {
                case 'A': complement.append('T'); break;
                case 'T': complement.append('A'); break;
                case 'C': complement.append('G'); break;
                case 'G': complement.append('C'); break;
                default: break;
            }
        }
        return complement.toString();
    }
    public static String toMRNA(String sequence) {
        String complement = toComplement(sequence);
        int length = complement.length();
        StringBuilder mRNA = new StringBuilder();
        for (int i = 0; i < length; i++) {
            switch(complement.charAt(i)) {
                case 'A' : mRNA.append('U'); break;
                case 'T' : mRNA.append('A'); break;
                case 'C' : mRNA.append('G'); break;
                case 'G' : mRNA.append('C'); break;
                default: break;
            }
        }
        return mRNA.toString();
    }

    public static String proteinLookup(String seq) {
        Dictionary<String, String> protein = new Hashtable<String, String>();
        protein.put("UUU", "Phe");
        protein.put("UUC", "Phe");
        protein.put("UUA", "Leu");
        protein.put("UUG", "Leu");
        protein.put("UCU", "Ser");
        protein.put("UCC", "Ser");
        protein.put("UCA", "Ser");
        protein.put("UCG", "Ser");
        protein.put("UAU", "Tyr");
        protein.put("UAC", "Tyr");
        protein.put("UAA", "STOP");
        protein.put("UAG", "STOP");
        protein.put("UGU", "Cys");
        protein.put("UGC", "Cys");
        protein.put("UGA", "STOP");
        protein.put("UGG", "Trp");
        protein.put("CUU", "Leu");
        protein.put("CUC", "Leu");
        protein.put("CUA", "Leu");
        protein.put("CUG", "Leu");
        protein.put("CCU", "Pro");
        protein.put("CCC", "Pro");
        protein.put("CCA", "Pro");
        protein.put("CCG", "Pro");
        protein.put("CAU", "His");
        protein.put("CAC", "His");
        protein.put("CAA", "Gln");
        protein.put("CAG", "Gln");
        protein.put("CGU", "Arg");
        protein.put("CGC", "Arg");
        protein.put("CGA", "Arg");
        protein.put("CGG", "Arg");
        protein.put("AUU", "Ile");
        protein.put("AUC", "Ile");
        protein.put("AUA", "Ile");
        protein.put("AUG", "Met");
        protein.put("ACU", "Thr");
        protein.put("ACC", "Thr");
        protein.put("ACA", "Thr");
        protein.put("ACG", "Thr");
        protein.put("AAU", "Asn");
        protein.put("AAC", "Asn");
        protein.put("AAA", "Lys");
        protein.put("AAG", "Lys");
        protein.put("AGU", "Ser");
        protein.put("AGC", "Ser");
        protein.put("AGA", "Arg");
        protein.put("AGG", "Arg");
        protein.put("GUU", "Val");
        protein.put("GUC", "Val");
        protein.put("GUA", "Val");
        protein.put("GUG", "Val");
        protein.put("GCU", "Ala");
        protein.put("GCC", "Ala");
        protein.put("GCA", "Ala");
        protein.put("GCG", "Ala");
        protein.put("GAU", "Asp");
        protein.put("GAC", "Asp");
        protein.put("GAA", "Glu");
        protein.put("GAG", "Glu");
        protein.put("GGU", "Gly");
        protein.put("GGC", "Gly");
        protein.put("GGA", "Gly");
        protein.put("GGG", "Gly");
        if (seq.length() != 3) {
            return null;
        }
        else {
            return protein.get(seq);
        }
    }

    public static String toProtein(String sequence) {
        String mRNA = toMRNA(sequence);
        int length = mRNA.length();
        StringBuilder protein = new StringBuilder();
        for (int i = 0; i < length; i+=3) {
            StringBuilder threeSequence = new StringBuilder();
            threeSequence.append(mRNA.charAt(i));
            threeSequence.append(mRNA.charAt(i+1));
            threeSequence.append(mRNA.charAt(i+2));
            protein.append(proteinLookup(threeSequence.toString()));
            protein.append(' ');
            //System.out.println(threeSequence.toString());
        }
        return protein.toString();
    }
    public static String toTriplicate(String sequence) {
        StringBuilder triplicate = new StringBuilder();
        int length = sequence.length();
        for (int i = 0; i < length; i+=3) {
            triplicate.append(sequence.charAt(i));
            triplicate.append(sequence.charAt(i+1));
            triplicate.append(sequence.charAt(i+2));
            triplicate.append(' ');
        }
        return triplicate.toString();
    }
}