package com.pera.sira;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Random;

/**
 * Created by Ishan Madhusanka on 11/07/2015.
 */
public class StringFinder {
    HashMap<String,HashMap<Integer,String>> keywords = new HashMap<String,HashMap<Integer,String>>();
    HashMap propword = new HashMap<String,String>();

    public StringFinder() {
        initialiseKeyword();
        initialisePropword();
    }

    private void initialisePropword(){
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
        propword.put("cn","can");
        propword.put("cum","come");
        propword.put("cm","come");
//d
        propword.put("dy","day");
        propword.put("dng","doing");
        propword.put("doin","doing");
        propword.put("don't","do not");
        propword.put("dnt","do not");
//e
        propword.put("eve","evening");
//f
        propword.put("fr","for");
        propword.put("4","for");

//g
        propword.put("gd","good");
        propword.put("gud","good");
        propword.put("ge","good evening");
        propword.put("gm","good morning!");
        propword.put("gmrng","good morning");
        propword.put("vgm","good morning");
        propword.put("gn","good night");
        propword.put("gf","girlfriend");
//h
        propword.put("hpy","happy");
        propword.put("hbd","happy birth day");
        propword.put("hv","have");
        propword.put("hav","have");
        propword.put("hello","hi");
        propword.put("hw","how");
//i
        propword.put("s","is");
        propword.put("z","is");
//j
//k
//l
        propword.put("lets","let us");
        propword.put("let's","let us");
        propword.put("lts","let us");
        propword.put("lv","love");
        propword.put("luv","love");
        propword.put("lnch","lunch");
//m
        propword.put("mk","make");
        propword.put("mt","meet");
        propword.put("ms","miss");
        propword.put("mis","miss");
        propword.put("mz","miss");
        propword.put("miz","miss");
        propword.put("mrng","morning");
        propword.put("morn","morning");
        propword.put("mrning","morning");
//n
        propword.put("nt","not");
        propword.put("nw","now");
        propword.put("n8","night");
        propword.put("nyt","night");
        propword.put("ni8","night");
        propword.put("nite","night");
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
        propword.put("pls","please");
//q
//r
        propword.put("rply","reply");
//s
        propword.put("c","see");
        propword.put("cu","see you");
//t
        propword.put("thankx","thank you");
        propword.put("tnx","thank you");
        propword.put("thnku","thank you");
        propword.put("thnkx","thank you");
        propword.put("thankz","thank you");
        propword.put("thnkz","thank you");
        propword.put("thanks","thank you");
        propword.put("dis","this");
        propword.put("ths","this");
        propword.put("thz","this");
        propword.put("2","to");
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
        propword.put("whatsup","what is up");
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
        HashMap question_1 = new HashMap<Integer,String>();
            question_1.put(1,"Good Morning!");
            question_1.put(2,"Wish you the same!");
            question_1.put(3,"Good Morning!");
            question_1.put(4,"Good Morning!");
            question_1.put(5,"Good Morning!");
        keywords.put("good morning",question_1);

        /*HashMap question_2 = new HashMap<Integer,String>();
            question_2.put(1,"");
            question_2.put(2,"");
            question_2.put(3,"");
            question_2.put(4,"");
            question_2.put(5,"");
        keywords.put("where are you",question_2);*/

        /*HashMap question_3= new HashMap<Integer,String>();
            question_3.put(1,"");
            question_3.put(2,"");
            question_3.put(3,"");
            question_3.put(4,"");
            question_3.put(5,"");
        keywords.put("what are you doing",question_3);*/

        HashMap question_4= new HashMap<Integer,String>();
            question_4.put(1,"Hell yeah");
            question_4.put(2,"Yup. Sorry. :-(");
            question_4.put(3,"Sorry but yes.");
            question_4.put(4,"Hmm. yes.");
            question_4.put(5,"Yeah. :-(");
        keywords.put("are you busy now",question_4);

        HashMap question_5= new HashMap<Integer,String>();
            question_5.put(1,"Wish you the same. :-)");
            question_5.put(2,"Happy New Year!!!");
            question_5.put(3,"Wish you a very happy new year!!!");
            question_5.put(4,"Happy new year!");
            question_5.put(5,"Thank you very much. Wish you the same.");
        keywords.put("happy new year",question_5);

        HashMap question_6= new HashMap<Integer,String>();
            question_6.put(1,"Merry Christmas!");
            question_6.put(2,"Merry Xmas!!!");
            question_6.put(3,"Merry Christmas and a Happy New Year!!!");
            question_6.put(4,"Merry Xmas and a Happy New Year!!!");
            question_6.put(5,"Wish you the same!!!");
        keywords.put("merry christmas",question_6);

        HashMap question_7= new HashMap<Integer,String>();
            question_7.put(1,"I know you do.");
            question_7.put(2,"Awesome!");
            question_7.put(3,"I know you do.");
            question_7.put(4,"I know you do.");
            question_7.put(5,"I know you do.");
        keywords.put("i love you",question_7);

        HashMap question_8= new HashMap<Integer,String>();
            question_8.put(1,"I miss you too.");
            question_8.put(2,"Miss you too.");
            question_8.put(3,"Hmm.. :-(");
            question_8.put(4,"Hmm. I know.");
            question_8.put(5,"Hmm.. I miss you too.");
        keywords.put("miss you",question_8);

        HashMap question_9= new HashMap<Integer,String>();
            question_9.put(1,"Good night!");
            question_9.put(2,"Good night. Sleep tight.");
            question_9.put(3,"Good night. Sleep well.");
            question_9.put(4,"Sweet dreams. Good night.");
            question_9.put(5,"Sweet dreams. Sleep well.");
        keywords.put("good night",question_9);

        HashMap question_10 = new HashMap<Integer,String>();
            question_10.put(1,"Thank you!");
            question_10.put(2,"Thank you very much.");
            question_10.put(3,"Thanks. :-)");
            question_10.put(4,"Thank you very much.");
            question_10.put(5,"Thank you very much.");
        keywords.put("happy birth day",question_10);

        HashMap question_11 = new HashMap<Integer,String>();
            question_11.put(1,"Hi! Sorry. I'm busy right now");
            question_11.put(2,"Hi! I'll catch you later okay? I'm busy right now.");
            question_11.put(3,"I'm Sorry. A little busy right now.");
            question_11.put(4,"Hi! Sorry. I'm busy. I'll call you back later.");
            question_11.put(5,"I'm sorry. I'm busy with some work. I'll text you later.");
        keywords.put("hi",question_11);

        HashMap question_12 = new HashMap<Integer,String>();
            question_12.put(1,"The user is busy right now. I am SiRA.");
            question_12.put(2,"The user is busy right now. I am SiRA.");
            question_12.put(3,"The user is busy right now. I am SiRA.");
            question_12.put(4,"The user is busy right now. I am SiRA.");
            question_12.put(5,"The user is busy right now. I am SiRA.");
        keywords.put("who is this",question_12);

        HashMap question_13 = new HashMap<Integer,String>();
            question_13.put(1,"I'm Busy. I'll eat later.");
            question_13.put(2,"I'm Busy. I'll eat later.");
            question_13.put(3,"I'm Busy. I'll eat later.");
            question_13.put(4,"I'm Busy. I'll eat later.");
            question_13.put(5,"I'm Busy. I'll eat later.");
        keywords.put("did you eat",question_13);

        HashMap question_14 = new HashMap<Integer,String>();
            question_14.put(1,"Shall we talk about this later? I'm busy right now.");
            question_14.put(2,"Shall we talk about this later? I'm busy right now.");
            question_14.put(3,"Shall we talk about this later? I'm busy right now.");
            question_14.put(4,"Shall we talk about this later? I'm busy right now.");
            question_14.put(5,"Shall we talk about this later? I'm busy right now.");
        keywords.put("are you angry with me",question_14);

        HashMap question_15 = new HashMap<Integer,String>();
            question_15.put(1,"A little busy right now.");
            question_15.put(2,"A little busy right now");
            question_15.put(3,"A little busy right now");
            question_15.put(4,"A little busy right now");
            question_15.put(5,"A little busy right now");
        keywords.put("what is up",question_15);

        HashMap question_16 = new HashMap<Integer,String>();
            question_16.put(1,"User is with me. I am SiRA.");
            question_16.put(2,"User is busy right now. I'm SiRA.");
            question_16.put(3,"I'm busy right now. Let's catch up later.");
            question_16.put(4,"I'm busy right now. Let's catch up later.");
            question_16.put(5,"User is with me. I am SiRA.");
        keywords.put("whom are you with",question_16);

        HashMap question_17 = new HashMap<Integer,String>();
            question_17.put(1,"User is busy.");
            question_17.put(2,"I'm SiRA. User is busy.");
            question_17.put(3,"I'm SiRA. User is busy.");
            question_17.put(4,"No one but SiRA");
            question_17.put(5,"No one but SiRA");
        keywords.put("who is with you",question_17);

        HashMap question_18 = new HashMap<Integer,String>();
            question_18.put(1,"A little busy right now. Can we talk about this later?");
            question_18.put(2,"A little busy right now. Can we talk about this later?");
            question_18.put(3,"A little busy right now. Can we talk about this later?");
            question_18.put(4,"A little busy right now. Can we talk about this later?");
            question_18.put(5,"A little busy right now. Can we talk about this later?");
        keywords.put("do not try to make a fool out of me",question_18);

        HashMap question_19 = new HashMap<Integer,String>();
            question_19.put(1,"user is busy right now. I am SiRA.");
            question_19.put(2,"user is busy right now. I am SiRA.");
            question_19.put(3,"user is busy right now. I am SiRA.");
            question_19.put(4,"user is busy right now. I am SiRA.");
            question_19.put(5,"user is busy right now. I am SiRA.");
        keywords.put("who are you",question_19);

        HashMap question_20 = new HashMap<Integer,String>();
            question_20.put(1,"Sorry. I'm busy.");
            question_20.put(2,"Sorry. I'm busy");
            question_20.put(3,"Sorry. I'm busy");
            question_20.put(4,"Sorry. I'm busy");
            question_20.put(5,"Sorry. I'm busy");
        keywords.put("reply me",question_20);

        HashMap question_21 = new HashMap<Integer,String>();
            question_21.put(1,"I'll tell you later. I'm busy right now.");
            question_21.put(2,"I'll tell you later. I'm busy right now.");
            question_21.put(3,"I'll tell you later. I'm busy right now.");
            question_21.put(4,"I'll tell you later. I'm busy right now.");
            question_21.put(5,"I'll tell you later. I'm busy right now.");
        keywords.put("will you meet me",question_21);

        HashMap question_22 = new HashMap<Integer,String>();
            question_22.put(1,"Yeah. I'm busy now. I'll text you later.");
            question_22.put(2,"Yeah. I'm busy now. I'll text you later.");
            question_22.put(3,"Yeah. I'm busy now. I'll text you later.");
            question_22.put(4,"Yeah. I'm busy now. I'll text you later.");
            question_22.put(5,"Yeah. I'm busy now. I'll text you later.");
        keywords.put("are you okay",question_22);

        HashMap question_23 = new HashMap<Integer,String>();
            question_23.put(1,"Okay. I will.");
            question_23.put(2,"Yeah. Sure.");
            question_23.put(3,"Okay.");
            question_23.put(4,"Yeah. I will.");
            question_23.put(5,"Okay. Sorry for not calling right now.");
        keywords.put("call me as soon as possible",question_23);

        HashMap question_24 = new HashMap<Integer,String>();
            question_24.put(1,"Not now. I will call you later for sure.");
            question_24.put(2,"Okay. Sorry for not calling right now.I'm busy.");
            question_24.put(3,"Not now. I will call you later for sure.");
            question_24.put(4,"Okay. Sorry for not calling right now.I'm busy.");
            question_24.put(5,"Okay. Sorry for not calling right now.I'm busy.");
        keywords.put("call me",question_24);

        HashMap question_25 = new HashMap<Integer,String>();
            question_25.put(1,"Mm.. Not right now.");
            question_25.put(2,"Mm.. Not right now.");
            question_25.put(3,"Mm.. Not right now.");
            question_25.put(4,"Mm.. Not right now.");
            question_25.put(5,"Mm.. Not right now.");
        keywords.put("when are you coming",question_25);

        HashMap question_26 = new HashMap<Integer,String>();
            question_26.put(1,"Mm.. I'll be late.");
            question_26.put(2,"Mm.. I'll be late.");
            question_26.put(3,"Mm.. I'll be late.");
            question_26.put(4,"Mm.. I'll be late.");
            question_26.put(5,"Mm.. I'll be late.");
        keywords.put("we are waiting for you",question_26);

        HashMap question_27 = new HashMap<Integer,String>();
            question_27.put(1,"Good evening!!");
            question_27.put(2,"Wish you the same.");
            question_27.put(3,"Wish you the same");
            question_27.put(4,"Wish you the same");
            question_27.put(5,"Wish you the same");
        keywords.put("good evening",question_27);

        HashMap question_28 = new HashMap<Integer,String>();
            question_28.put(1,"No problem");
            question_28.put(2,"You are welcome.");
            question_28.put(3,"It's my pleasure.");
            question_28.put(4,"Don't mention it.");
            question_28.put(5,"Okay. :-)");
        keywords.put("thank you",question_28);

        HashMap question_29 = new HashMap<Integer,String>();
            question_29.put(1,"I,m doing fine.A little busy right now.");
            question_29.put(2,"I,m busy right now");
            question_29.put(3,"I,m doing fine.A little busy right now");
            question_29.put(4,"I,m doing fine.A little busy right now");
            question_29.put(5,"I,m doing fine.A little busy right now");
        keywords.put("how are you",question_29);

        HashMap question_30 = new HashMap<Integer,String>();
            question_30.put(1,"Not right now.I'm busy.");
            question_30.put(2,"I'm busy. May be later.");
            question_30.put(3,"I'm busy. May be later.");
            question_30.put(4,"Not right now.");
            question_30.put(5,"I'm busy. May be later.");
        keywords.put("can we meet",question_30);

        HashMap question_31 = new HashMap<Integer,String>();
            question_31.put(1,"I'm busy now. Sorry.");
            question_31.put(2,"I'm busy now. Sorry.");
            question_31.put(3,"I'm busy now. Sorry.");
            question_31.put(4,"I'm busy now. Sorry.");
            question_31.put(5,"I'm busy now. Sorry.");
        keywords.put("let us have lunch",question_30);
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
        HashMap<Integer, String> temp;
        for(String s:keys1){
            CharSequence cs=s;
            if(finmsg.contains(cs)){
                temp = keywords.get(s);
                Random num = new Random();
                int numm = num.nextInt(6)+1;
                result=temp.get(numm).toString();
            }
        }
        String [] finalmessage = result.split(" ");
        for(int q=0;q<finalmessage.length;q++){
            String newS = finalmessage[q];
            if (newS=="user" || newS == "User")
                finalmessage[q]= MainActivity.getUserName();
        }
        for(String finString:finalmessage){
            result+=finString+" "; 
        }
        return result;
    }
}