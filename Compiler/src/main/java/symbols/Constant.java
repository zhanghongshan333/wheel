package symbols;

import inter.Expr;
import lexer.Number;
import lexer.Token;
import lexer.Word;

/**
 * @author: guangxush
 * @create: 2020/06/29
 */
public class Constant extends Expr {
    public Constant(Token token, Type type) {
        super(token, type);
    }

    public Constant(int i) {
        super(new Number(i), Type.Int);
    }

    public static final Constant True = new Constant(Word.True, Type.Bool);

    public static final Constant False = new Constant(Word.False, Type.Bool);

    @Override
    public void jumping(int t, int f) {
        if (this == True && t != 0) {
            emit("goto L" + t);
        } else if (this == False && f != 0) {
            emit("goto L" + f);
        }
    }
}
