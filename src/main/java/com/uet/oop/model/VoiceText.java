package com.uet.oop.model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class VoiceText {

    private static final String VOICENAME_kevin = "kevin";
    private final String text;

    public VoiceText(String text) {
        this.text = text;
    }

    public void speak() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);
        voice.allocate();

        voice.speak(text);
//        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
//        VoiceManager voiceManager = VoiceManager.getInstance();
//        Voice[] voices = voiceManager.getVoices();
//
//        System.out.println("Các giọng nói có sẵn:");
//        for (Voice voice : voices) {
//            System.out.println(voice.getName());
//        }
    }
}