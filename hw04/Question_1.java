/**
 * Write a recursive function to search a given
 * string in another given bigger string.
 * The function should return the index of the
 * ith occurrence of the query string and return -1
 * when the query string does not occur in the big
 * string or the number of occurrences is less
 * than i.
 * */
public class Question_1{
    
    /**
     * public SubStringCount method to call private SubStringCount method
     * @param mainString main string to search query string on it
     * @param query given substring to look for
     * @param targetOccur wanted nth occurrence of query string
     * @return private SubStringCount method
     */
    public static int SubStringCount(String mainString, String query, int targetOccur){
        return SubStringCount(mainString, query, 0, targetOccur, 0);
    }

    /**
     * The function should return the index of the ith occurrence of 
     * the query string and return -1 when the query string does not occur
     * in the big string or the number of occurrences is less than i.
     * @param mainString main string to search query string on it
     * @param query given substring to look for
     * @param currentOccur index of current occurrence of the query string
     * @param targetOccur wanted nth occurrence of query string
     * @param index index of nth occurrence
     * @return index of target occurrence or -1
     */
    private static int SubStringCount(String mainString, String query, int currentOccur, int targetOccur, int index){
        int mainLength = mainString.length();
        int queryLength = query.length();

        /*Base Case*/
        if (mainLength == 0 || mainLength < queryLength
                || queryLength == 0 || targetOccur <= 0)
            return -1;

        /*
        check given query String 
        if string is found increase return value, 
        then recursively traverse in mainString
        */
        if (mainString.substring(0, queryLength).equals(query)){
            currentOccur++;
            if(currentOccur == targetOccur)
                return index;
        }
        /*
        continue to search recursively
        */
        return SubStringCount(mainString.substring(1), query, currentOccur, targetOccur, index + 1);
    }
    
}