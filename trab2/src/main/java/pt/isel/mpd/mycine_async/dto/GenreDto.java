package pt.isel.mpd.mycine_async.dto;

public class GenreDto {
	private int id;
	private String name;

	public GenreDto(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() { return id; }

	public String getName() { return name; }

	@Override
	public String toString() {
		return "{ "
				+ "name = " + name
				+ ", id = " + id
				+ " }";
	}
}
