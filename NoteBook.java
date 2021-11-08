package by.epam.hw.t1.task2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class NoteBook
{
	private String owner;
	private List<Note> notes;

	public NoteBook()
	{
	}

	public NoteBook(List<Note> notes)
	{
		this.owner = owner;
		this.notes = notes;
	}

	public NoteBook(String owner, List<Note> notes)
	{
		this.owner = owner;
		this.notes = notes;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public List<Note> getNotes()
	{
		return notes;
	}

	public void setNotes(List<Note> notes)
	{
		this.notes = notes;
	}

	List<Note> sortByDate(List<Note> notes)
	{
		Collections.sort(notes, new Comparator<Note>()
		{
			@Override
			public int compare(Note o1, Note o2)
			{
				return o1.getDateCreated().compareTo(o2.getDateCreated());
			}
		});

		return notes;
	}

	List<Note> sortByContent(List<Note> notes)
	{
		Collections.sort(notes, new Comparator<Note>()
		{
			@Override
			public int compare(Note o1, Note o2)
			{
				return o1.getContent().compareTo(o2.getContent());
			}
		});
		return notes;
	}




	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (!(o instanceof NoteBook))
			return false;
		NoteBook noteBook = (NoteBook) o;
		return getOwner().equals(noteBook.getOwner()) &&
				getNotes().equals(noteBook.getNotes());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(getOwner(), getNotes());
	}

	@Override
	public String toString()
	{
		return "NoteBook1{" +
				"userAccountId='" + owner + '\'' +
				", notes=" + notes +
				'}' ;
	}
}

class Note
{
	private int id;

	private String title;

	private String content;

	private Date dateCreated;


	public Note(int id, String title, String content, Date dateCreated)
	{
		this.id = id;
		this.title = title;
		this.content = content;
		this.dateCreated = dateCreated;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Note note = (Note) o;
		return id == note.id &&
				title.equals(note.title) &&
				content.equals(note.content) &&
				dateCreated.equals(note.dateCreated);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, title, content, dateCreated);
	}

	@Override
	public String toString()
	{
		return "Note{" +
				"id='" + id + '\'' +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", dateCreated=" + dateCreated +
				'}' + System.lineSeparator();
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Date getDateCreated()
	{
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}
}

class NoteBookConsoleView
{

	int index;

	static void print(NoteBook notes)
	{
		System.out.println(notes);
	}

	static void print(ArrayList<Note> note)
	{
		System.out.println(note);
	}

	static void print(ArrayList<Note> note, int index)
	{
		System.out.println(note.get(index));
	}

	static void printSeveralItems(ArrayList<Note> note)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Введите количество строк, которые вы хотите распечатать");
		int index = sc.nextInt();

		for (int i = 0; i < index; i++)
		{

			System.out.println(note.get(index));
		}
	}
}




class Main
{
	public static void main(String[] args)
	{

		ArrayList <Note> db = new ArrayList<Note>();
		NoteBookProvider instance = NoteBookProvider.getInstance();
		NoteBook notebook1 = instance.getNoteBook();

		db.add(new Note(4, "Text1", "Desc content 1", new Date("11/05/2021")));
		db.add(new Note(2, "Text2", "Abcd content 2 ", new Date("09/06/2021") ));
		db.add(new Note(3, "Text3", "Qwerty content 3", new Date() ));


		notebook1.sortByDate(db);

		NoteBookConsoleView.print(db);
		NoteBookConsoleView.print(db, 2);

		notebook1.sortByContent(db);
		NoteBookConsoleView.print(db);

		NoteBookConsoleView.printSeveralItems(db);
	}
}


class NoteBookProvider
{

	private static NoteBookProvider instance = new NoteBookProvider();
	private  NoteBook noteBook = new NoteBook();
		private NoteBookProvider (){}

	public static NoteBookProvider getInstance(){

		return instance;
	}

	public NoteBook getNoteBook()
	{
		return noteBook;
	}

	public void setNoteBook(NoteBook noteBook)
	{
		this.noteBook = noteBook;
	}
}


