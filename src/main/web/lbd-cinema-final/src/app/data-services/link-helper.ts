export class LinkHelper {
    public static getIdFromSelfHref(href: string): Number {
        let aux = "";
        for (let i = href.lastIndexOf('/') + 1; i < href.length; i++) {
            aux += href.charAt(i);
        }

        return new Number(aux);
    }
}
