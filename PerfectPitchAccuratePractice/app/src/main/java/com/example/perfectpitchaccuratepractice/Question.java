package com.example.perfectpitchaccuratepractice;

/**
 * an abstract class of Question
 */
public abstract class Question {
  /**
   * an array of texts that constitute the question
   */
  String[] texts;
  /**
   * the note pool, which can be generated from the filter page, used to form a question
   */
  Note[] notePool;

  /**
   * Constructor
   */
  Question() {
  }

  /**
   * Setter for note pool
   */ 
  void setNotePool(Note [] notes) {
    this.notePool = notes;
  }

  /**
   * getter of the text of the question
   */
  String[] getTexts() {
    return this.texts;
  }

  /**
   * print texts separated by space in stdout
   */
  void print_question_texts() {
    for (String t: this.getTexts()) {
      System.out.print(t + " ");
    }
    System.out.println();
  }

  /**
   * abstract function to generate random question given current fields
   */
  void generate_random_question() {
  }
}