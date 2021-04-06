package se.lexicon.java_33_first_rest.data;

import org.springframework.stereotype.Component;

@Component
public class PersonIdSequencer{

    private int currentId;

    public int getNextId(){
        return ++currentId;
    }

}
