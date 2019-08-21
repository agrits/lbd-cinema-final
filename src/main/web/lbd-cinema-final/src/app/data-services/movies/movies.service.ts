import { Injectable } from "@angular/core";
import { Movie, MovieAttrs } from "src/app/data-entity/movies/movie";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { DefaultService } from "../default.service";

@Injectable({
  providedIn: "root"
})
export class MoviesService extends DefaultService {
  protected moviesUrl: string = "/movies";
  getMovies(): Observable<Movie[]> {
    return this.httpClient
      .get<MovieAttrs[]>(this.apiUrl + this.moviesUrl)
      .pipe(map(data => data.map(movieAttrs => new Movie(movieAttrs))));
  }

  createMovie(movie: Movie): Observable<Movie> {
    return this.httpClient.post<MovieAttrs>(this.moviesUrl, movie);
  }

  updateMovie(movie: Movie): Observable<Movie> {
    return this.httpClient.put<MovieAttrs>(this.moviesUrl + "/" + movie.id, movie);
  }

  deleteMovie(id: number): Observable<Movie> {
    return this.httpClient.delete<Movie>(this.moviesUrl + "/" + id);
  }
}
