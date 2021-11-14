import java.util.*;
import java.io.*;

class Solution {
	public class Song implements Comparable<Song> {
		int idx, plays;
		String genre;

		public Song(int idx, String genre, int plays) {
			this.idx = idx;
			this.genre = genre;
			this.plays = plays;
		}

		@Override
		public int compareTo(Song o) {
			if (this.plays == o.plays) {
				return this.idx - o.idx;
			}
			return o.plays - this.plays;
		}
	}

	public class Genre implements Comparable<Genre> {
		String name;
		int plays;

		public Genre(String name, int plays) {
			this.name = name;
			this.plays = plays;
		}

		@Override
		public int compareTo(Genre o) {
			return o.plays - this.plays;
		}
	}

	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> genresPlay = new HashMap<>();
		HashMap<String, PriorityQueue<Song>> genreSongs = new HashMap<>();
		PriorityQueue<Genre> pq = new PriorityQueue<>();

		for (int i = 0; i < genres.length; i++) {
			if (!genresPlay.containsKey(genres[i])) {
				genresPlay.put(genres[i], 0);
				genreSongs.put(genres[i], new PriorityQueue<>());
			}
			genresPlay.put(genres[i], genresPlay.get(genres[i]) + plays[i]);
			genreSongs.get(genres[i]).add(new Song(i, genres[i], plays[i]));
		}

		for (String key : genresPlay.keySet()) {
			pq.add(new Genre(key, genresPlay.get(key)));
		}

		ArrayList<Integer> arr = new ArrayList<>();

		while (!pq.isEmpty()) {
			String genreName = pq.poll().name;
			int size = Math.min(genreSongs.get(genreName).size(), 2);
			for (int i = 0; i < size; i++) {
				arr.add(genreSongs.get(genreName).poll().idx);
			}
		}

		int[] answer = new int[arr.size()];
		int idx = 0;

		for (int n : arr) {
			answer[idx] = n;
			idx += 1;
		}

		return answer;
	}
}