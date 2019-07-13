package com.example.perfectpitchaccuratepractice.filter;

import com.example.perfectpitchaccuratepractice.bitmap.NotesBitmap;
import com.example.perfectpitchaccuratepractice.note.Note;

/**
 * A filter that will filter out the notes that does not belong to this range
 */
public class NotesRangeFilter extends NotesFilter {
  public NotesRangeFilter(Note from_note, Note to_note) {
    this.bitmap = NotesBitmap.getNotesBitmapFromRange(from_note, to_note);
  }
}
