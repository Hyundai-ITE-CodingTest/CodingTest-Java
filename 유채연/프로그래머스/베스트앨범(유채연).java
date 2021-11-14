import java.util.*;

class Solution { 
    public static class Music{
        int id;
        String genre;
        int play;
        public Music(int id, String genre, int play){
            this.id = id;
            this.genre = genre;
            this.play = play;
        }
        public int getId(){
            return id;
        }
        public String getGenre(){
            return genre;
        }
        public int getPlay(){
            return play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList<Integer> answerList = new ArrayList();
        // 장르와 재생 횟수를 담는 해시맵
        HashMap<String, Integer> genrePlayMap = new HashMap<>();
        // 장르에 따른 Music 객체의 배열을 담는 해시맵
        HashMap<String, ArrayList<Music>> musicMap = new HashMap<>();
        // 재생횟수가 많은 장르별로 모음
        ArrayList<String> genreSortList = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++){
            // genrePlayMap 삽입
            genrePlayMap.put(genres[i], genrePlayMap.getOrDefault(genres[i], 0) + plays[i]);
            // musicMap 삽입
            ArrayList<Music> musicList = musicMap.getOrDefault(genres[i], new ArrayList<Music>());
            musicList.add(new Music(i, genres[i], plays[i]));
            musicMap.put(genres[i], musicList);
        }
        
        // genreSortList에 크기 내림차순 삽입
        int max=0;
        String maxKey="";
        while(!genrePlayMap.isEmpty()) {
            max = 0;
            for(String gen : genrePlayMap.keySet()) {
                if(max < genrePlayMap.get(gen)) {
                    max = genrePlayMap.get(gen);
                    maxKey = gen;
                }
            }
            genrePlayMap.remove(maxKey);
            genreSortList.add(maxKey);
        }
        
        // 정렬 기준 : play 내림차순, play가 동일할 경우 id 오름차순
        Comparator<Music> comparator = new Comparator<Music>(){
            @Override
            public int compare(Music o1, Music o2){
                if(o2.play == o1.play){
                    return o1.id-o2.id;
                }
                return o2.play-o1.play;
            }
        };
        
        for(String gen : genreSortList){
            //장르별 Music 객체의 리스트를 담는다.
            ArrayList<Music> musicList = musicMap.get(gen);
            musicList.sort(comparator);
            //장르에서 2개 이하씩 뽑아낸다.
            if(musicList.size() < 2){
                for(int i = 0; i<musicList.size(); i++){
                    answerList.add(musicList.get(i).getId());
                }
            }else{
                answerList.add(musicList.get(0).getId());
                answerList.add(musicList.get(1).getId());
            }
        }
        
        answer = new int[answerList.size()];
        
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
		return answer;
    }
}