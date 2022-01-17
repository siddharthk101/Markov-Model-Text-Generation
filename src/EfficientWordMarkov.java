import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov {
    private Map<WordGram,ArrayList<String>> myMap;

    public EfficientWordMarkov(){
        this(3);
    }

    public EfficientWordMarkov(int order) {
        super(order);
        myMap = new HashMap<>();
    }

    @Override
    public void setTraining(String text) {
        super.setTraining(text);
        myMap.clear();
        WordGram current;
        String nextWord = "";
        for(int i = 0; i < myWords.length - myOrder + 1; i++){
            current = new WordGram(myWords, i, myOrder);
            if(i + myOrder >= myWords.length){
                nextWord = PSEUDO_EOS;
            } else{
                nextWord = myWords[i+myOrder];
            }

            if(!myMap.containsKey(current)){
                myMap.put(current, new ArrayList<String>());
            }
            myMap.get(current).add(nextWord);

        }
    }
    @Override
    public ArrayList<String> getFollows(WordGram w) {
        return myMap.get(w);
    }
}
