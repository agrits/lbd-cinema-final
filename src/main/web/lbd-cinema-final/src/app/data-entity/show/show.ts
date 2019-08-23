import { LinkHelper } from 'src/app/data-services/link-helper';

export interface GetShowsResponse {
    _embedded: {
      shows: ShowAttributes[];
    };
  }

export interface ShowAttributes {
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
    _links: {
        self: {
            href: string;
        };
        show:{
            href: string;
        };
    };
}

export class Show {
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
    _links: {
        self: {
            href: string;
        };
    };

    constructor(showAttribtes: Partial<ShowAttributes>) {
        //this.id = showAttribtes.id;
        this.hall_id = showAttribtes.hall_id;
        this.movie_id = showAttribtes.movie_id;
        this.time = showAttribtes.time;
        this.language = showAttribtes.language;
        this.threeD = showAttribtes.threeD;
        this.subtitles = showAttribtes.subtitles;
        this.lector=showAttribtes.lector;
        this.dubbing = showAttribtes.dubbing;
        this.price = showAttribtes.price;
        this._links = showAttribtes._links;
        this.id = LinkHelper.getIdFromSelfHref(this._links.self.href);
    }
}
