import { Component, OnInit } from '@angular/core';
import { ShowService } from 'src/app/data-services/show/show.service';
import { Show } from 'src/app/data-entity/show/show';
import { Movie } from 'src/app/data-entity/movies/movie';
import { MoviesService } from 'src/app/data-services/movies/movies.service';
import { withLatestFrom } from 'rxjs/operators';
import { CustomShow } from './custom-show';

@Component({
  selector: 'app-repertoire',
  templateUrl: './repertoire.component.html',
  styleUrls: ['./repertoire.component.css']
})
export class RepertoireComponent implements OnInit {

  shows: Show[];
  movies: Movie[];
  customShows: CustomShow[];

  constructor(private showService: ShowService, private movieService: MoviesService) { }

  ngOnInit() {

    this.movieService.getMovies().subscribe(x => {

      this.movies = x; //dla wszystkich 
      this.getShows();
    })

  }
  getShows() {
    this.showService.getLocalizations().subscribe(x => {
      this.shows = x
      for (let show of x)
        show["title"] = this.findMovie(show.movie_id);
    });
  }

  findMovie(id: number): string {
    //console.log(this.movies)
    for (let movie of this.movies) {
      if (id == movie.id){
        console.log(movie.title);
        return movie.title;
      }
    }
  }

}
