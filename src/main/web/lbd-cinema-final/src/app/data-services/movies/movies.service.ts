import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { GetMoviesResponse, Movie } from "src/app/data-entity/movies/movie";
import { DefaultService } from "../default.service";

@Injectable({
  providedIn: "root"
})
export class MoviesService extends DefaultService {

  getMovies(): Observable<Movie[]> {
    return this.httpClient
      .get<GetMoviesResponse>("http://localhost:8080/api/movie/movies").pipe(
        map(embedded => embedded._embedded.movies.map(movieAttrs => new Movie(movieAttrs)))
      )
  }
}
