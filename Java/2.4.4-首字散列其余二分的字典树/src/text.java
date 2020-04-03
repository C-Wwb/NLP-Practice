public class text
{
    public static void main(String[] args)
    {
        System.out.println(new Character('池').hashCode() - new Character('江').hashCode());
    }//return 1，是完美散列，输出区间是[0, 65535]
}
