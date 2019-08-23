import { Show } from 'src/app/data-entity/show/show';

export class CustomShow{
    id: Number;
    hall_id: number;
    movie_id: number;
    time: Date;
    language: string; //???
    threeD: boolean;
    subtitles: boolean;
    lector: boolean;
    dubbing: boolean;
    price: number;
    title: String

    constructor(show: Show)
    {
        this.id = show.id;
        this.hall_id = show.hall_id;
        this.movie_id = show.movie_id;
        this.time = show.time;
        this.language = show.language;
        this.threeD = show.threeD;
        this.subtitles = show.subtitles;
        this.lector = show.lector;
        this.dubbing = show.dubbing
        this.price = show.price;
    }
}
