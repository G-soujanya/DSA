public static void booleanMatrix1(int arr[][])
    {
        int rows=arr.length;
        int columns=arr[0].length;
        for (int i = 0; i < rows; i++) {
            for(int j=0;j<columns;j++)
            {
                if(arr[i][j]==1)
                {
                    int index=0;
                    while(index<j)
                    {
                        if(arr[i][index]!=1)
                            arr[i][index]=-1;
                        index++;
                    }
                    index=j+1;
                    while(index<columns)
                    {
                        if(arr[i][index]!=1)
                            arr[i][index]=-1;
                        index++;
                    }
                    index=0;
                    while(index<i)
                    {
                        if(arr[index][j]!=1)
                            arr[index][j]=-1;
                        index++;
                    }
                    index=i+1;
                    while(index<rows)
                    {
                        if(arr[index][j]!=1)
                            arr[index][j]=-1;
                        index++;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <columns ; j++) {
                if(arr[i][j]==-1)
                    arr[i][j]=1;
            }
        }
        for (int i = 0; i <rows ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public static void booleanMatrix2(int arr[][])
    {
        int rows=arr.length;
        int columns=arr[0].length;
        int row[]=new int[rows];
        int column[]=new int[columns];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <columns ; j++) {
                if(arr[i][j]==1)
                {
                    row[i]=1;
                    column[j]=1;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(row[i]==1 || column[j]==1)
                    arr[i][j]=1;
            }
        }
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public static void booleanMatrix3(int arr[][])
    {
        boolean row=false;
        boolean column=false;
        int rows=arr.length;
        int columns=arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(i==0 && arr[i][j]==1)
                    row=true;
                if(j==0 && arr[i][j]==1)
                    column=true;
                if(arr[i][j]==1)
                {
                    arr[0][j]=1;
                    arr[i][0]=1;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if(arr[0][j]==1 || arr[i][0]==1)
                    arr[i][j]=1;
            }
        }
        if(row)
        {
            for(int i=0;i<columns;i++)
                arr[0][i]=1;
        }
        if(column)
        {
            for (int i = 0; i < rows; i++) {
                arr[i][0]=1;
            }
        }
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public static void excelColumnName(int num)
    {
        StringBuilder columnName=new StringBuilder("");
        while (num>0)
        {
            int rem=num%26;
            if(rem==0)
            {
                columnName.append("z");
                num=num/26-1;
            }
            else
            {
                columnName.append((char)(rem-1+'a'));
                num=num/26;
            }

        }
        System.out.println(columnName.reverse());
    }
    static String letter="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String num_hash(int num)
    {
        int rem=num%26;
        int row=num/26;
        if(num<26)
        {
            return Character.toString(letter.charAt(num-1));
        }
        else
        {
            if(rem==0)
            {
                if(row==1)
                    return Character.toString(letter.charAt((26+rem-1)%26));
                else
                    return num_hash(row-1)+Character.toString(letter.charAt((26+rem-1)%26));
            }
            else
                return num_hash(row)+Character.toString(letter.charAt((26+rem-1)%26));
        }
    }
    public static void excelColumnName2(int num)
    {
        int arr[]=new int[10000];
        int i=0;
        while (num>0)
        {
            arr[i]=num%26;
            num=num/26;
            i++;
        }
        for(int j=0;j<i-1;j++)
        {
            if(arr[j]<=0)
            {
                arr[j]+=26;
                arr[j+1]=arr[j+1]-1;
            }
        }
        for (int j = i; j >=0; j--) {
            if(arr[j]>0)
                System.out.print((char)('A'+(arr[j]-1)));

        }
        System.out.println();
    }
