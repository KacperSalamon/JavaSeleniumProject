package Helpers;

public interface Sceanrio<input extends PageBasic, output extends PageBasic>{
    output run(input entry);
}
