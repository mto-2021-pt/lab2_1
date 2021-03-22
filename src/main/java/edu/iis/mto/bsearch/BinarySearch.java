/**
 *
 */
package edu.iis.mto.bsearch;

/**
 * Klasa implementująca wyszukiwanie binarne
 *
 */
public class BinarySearch {

    private BinarySearch() {}

    /**
     * Metoda realizujaca wyszukiwanie binarne
     *
     * @param key
     *            - szukany obiekt
     * @param seq
     *            - rosnaco uporzadkowana niepusta sekwencja
     * @return obiekt rezultatu o polach: - found (true jezeli znaleziony) - position (jezeli znaleziony - pozycja w
     *         sekwencji, jezeli nie znaleziony -1)
     */
    static SearchResult search(int key, int[] seq) {
        if(seq.length < 1 || !validateSeq(seq)) {
            throw new IllegalArgumentException();
        }
        int start = 0;
        int end = seq.length - 1;
        int center;
        SearchResult result = new SearchResult();

        while (start <= end) {
            center = (start + end) / 2;
            if (seq[center] == key) {
                result.setPosition(center);
                break;
            } else {
                if (seq[center] < key) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            }
        }
        return result;
    }

    private static boolean validateSeq(int[] seq) {
        for(int i = 0; i < seq.length - 1; i++) {
            if(seq[i] >= seq[i + 1]) {
                return false;
            }
            for(int j = i + 1; j < seq.length; j++) {
                if(i != j && seq[i] == seq[j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
