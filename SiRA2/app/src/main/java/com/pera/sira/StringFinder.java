package com.pera.sira;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by Ishan Madhusanka on 11/07/2015.
 */
public class StringFinder {
    HashMap keywords = new HashMap<String,String>();
    HashMap propword =new HashMap<String,String>();

    public StringFinder() {
        initialiseKeyword();
        initialisePropword();
    }

    private void initialisePropword(){
//28extra
//a
        propword.put("abt","about");
        propword.put("ngry","angry");
        propword.put("r","are");
        propword.put("ar","are");
        propword.put("asap","as soon as possible");
//b
        propword.put("bcz","because");
        propword.put("bcoz","because");
        propword.put("bc","because");
        propword.put("cuz","because");
        propword.put("b4","before");
        propword.put("bday","birth day");
        propword.put("b'day","birth day");
        propword.put("b'dy","birth day");
        propword.put("bdy","birth day");
        propword.put("bf","boyfriend");
        propword.put("bzy","busy");
//c
        propword.put("cl","call");
        propword.put("cum","come");
        propword.put("cm","come");
//d
        propword.put("dy","day");
        propword.put("dng","doing?");
        propword.put("doin","doing?");
        propword.put("don't","do not");
        propword.put("dnt","do not");
//e
        propword.put("eve","evening");
//f
        propword.put("fr","for");
//g
        propword.put("gd","good");
        propword.put("gud","good");
        propword.put("gm","good morning!");
        propword.put("gmrng","good morning");
        propword.put("gf","girlfriend");
//h
        propword.put("hpy","happy");
        propword.put("hbd","happy birth day");
        propword.put("hello","hi");
        propword.put("hw","how");
//i
        propword.put("s","is");
        propword.put("z","is");
//j
//k
//l
        propword.put("lv","love");
        propword.put("luv","love");
//m
        propword.put("mk","make");
        propword.put("ms","miss");
        propword.put("mis","miss");
        propword.put("mz","miss");
        propword.put("miz","miss");
        propword.put("mrng","morning");
        propword.put("morn","morning");
        propword.put("mrning","morning");
//n
        propword.put("nw","now");
        propword.put("n8","night");
        propword.put("nyt","night");
        propword.put("ni8","night");
//o
        propword.put("ok","okay");
        propword.put("k","okay");
        propword.put("kay","okay");
        propword.put("'kay","okay");
        propword.put("oky","okay");
        propword.put("o","or");
        propword.put("f","of");
//p
        propword.put("plz","please");
//q
//r
        propword.put("rply","reply");
//s
        propword.put("c","see");
        propword.put("cu","see you");
//t
        propword.put("dis","this");
        propword.put("ths","this");
        propword.put("thz","this");
        propword.put("2day","today");
        propword.put("2dy","today");
        propword.put("tday","today");
        propword.put("tdy","today");
        propword.put("tmrw","tomorrow");
        propword.put("2mrw","tomorrow");
        propword.put("tnite","tonight");
        propword.put("2nite","tonight");
        propword.put("tnyt","tonight");
//u
//v
//w
        propword.put("wtng","waiting");
        propword.put("v","we");
        propword.put("wat","what");
        propword.put("wht","what");
        propword.put("wuzup","what is up");
        propword.put("wassup","what is up");
        propword.put("wzsup","what is up");
        propword.put("sup","what is up");
        propword.put("what's","what is");
        propword.put("whn","when");
        propword.put("wn","when");
        propword.put("whr","where");
        propword.put("who's","who is");
        propword.put("wil","will");
        propword.put("vil","will");
        propword.put("wid","with");
        propword.put("wth","with");
        propword.put("y","why");
//x
        propword.put("xmas","christmas");
//y
        propword.put("yr","year");
        propword.put("u","you");
        propword.put("yo","you");
        propword.put("ur","your");
    }
    private void initialiseKeyword(){
        keywords.put("good morning","Good Morning");
        //keywords.put("where are you","I am at ");
        //keywords.put("what are you doing","");
        keywords.put("are you busy now","Hell yeah");
        keywords.put("happy new year","Wish you the same.");
        keywords.put("merry christmas","Merry Christmas!");
        keywords.put("i love you","I know you do");
        keywords.put("miss you","I miss you too.");
        keywords.put("good night","Good night");
        keywords.put("happy birth day","Thank you");
        keywords.put("hi","Hi! Sorry. I'm busy right now");
        keywords.put("who is this","The user is busy right now. I am SiRA.");
        keywords.put("did you eat","Hmm");
        keywords.put("are you angry with me","Hmm");
        keywords.put("what is up","The user is busy");
        keywords.put("whom are you with","The user is with me. I am SiRA.");
        keywords.put("who is with you","No one but SiRA");
        keywords.put("do not try to make a fool out of me","No. I'm not.");
        keywords.put("who are you","the user is busy right now. I am SiRA.");
        keywords.put("reply me","Sorry. I'm busy.");
        keywords.put("will you meet me","I'll tell you later.");
        keywords.put("okay","smile emoticon");
        keywords.put("call me as soon as possible","Okay. I will.");
        keywords.put("call me","Okay. I will call you later.");
        keywords.put("when are you coming","Mm.. Not right now.");
        keywords.put("we are waiting for you","Mm.. I'll be late.");
    }





    public String find(String message){
        String result="";
        if (message == null) {
            return result;
        }
        String msg=message.toLowerCase();
        String[] words=msg.split(" |\\?|\n");
        String[] newWords=new String[words.length];
        String finmsg="";

        for(int i=0;i<words.length;i++) {
            String s1 = words[i];
            if (propword.containsKey(s1)) {
                newWords[i] = propword.get(s1).toString();
            } else newWords[i] = s1;
        }
        for(String s3:newWords){
            finmsg+=s3+" ";
        }
        //System.out.println(finmsg);
        Set<String> keys1=keywords.keySet();
        for(String s:keys1){
            CharSequence cs=s;
            if(finmsg.contains(cs)){
                result=keywords.get(s).toString();
            }
        }
        return result;
    }
}