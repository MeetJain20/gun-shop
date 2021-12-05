class loadFile {
    public void loadData(string path)
     
    {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/Gunshop", "root", "dbms");
            stmt = conn.createStatement();
            String sql = "LOAD DATA INFILE " +path +" INTO TABLE gunshop FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\r\n' IGNORE 1 LINES;";
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error! Could Not get result from the Database");
        }
    }

        public void print_all() {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/Gunshop", "root", "dbms");
            stmt = conn.createStatement();
            String sql = "select * from gunshop;";
            stmt.execute(sql);

        }

    }
