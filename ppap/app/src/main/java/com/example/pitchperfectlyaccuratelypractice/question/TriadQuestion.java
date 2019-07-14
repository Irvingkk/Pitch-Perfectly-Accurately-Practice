package com.example.pitchperfectlyaccuratelypractice.question;
import com.example.pitchperfectlyaccuratelypractice.note.Note;
import com.example.pitchperfectlyaccuratelypractice.triad.Triad;

import java.util.Random;

/**
 * A Question in Triad practice mode
 */
public class TriadQuestion extends Question{

  /**
   * The triad that will be questioned 
   */
  Triad questionTriad;
  
  /**
   * a static Random
   */
  private static Random random = new Random();

  /**
   * generate question from note pool
   * <p>
   * remember to set note pool first
    */
  public void generate_random_question() {
    int rnd = random.nextInt(notePool.length);
    Note root = notePool[rnd];
    this.questionTriad = new Triad(root, Triad.getRandomTriadScale());
    Note[] triad_notes = this.questionTriad.getNotes();
    this.texts = new String[3];
    for (int i =0; i< 3; i++) {
      this.texts[i] = triad_notes[i].getText();
    }
  }


  /**
   * a way to use this class
   */
  public static void main(String args[]) {
    TriadQuestion tq = new TriadQuestion();
    tq.setNotePool(Note.generateNotesWithRange(24,36));

    int some_num = 100;
    System.out.println("Printing " + some_num + " random triad questions");
    for (int i = 0; i < some_num; i++) {
      tq.generate_random_question();
      tq.print_question_texts();
    }
  }
}