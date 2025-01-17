#!/bin/sh
hminame=HyperRAM_Memory_Interface_Top_inst

# inout is unknown in chisel, one bit array also missing
sed -i s/'input  .7.0. IO_hpram_dq'/'inout  [7:0] IO_hpram_dq'/g video_top.v
sed -i s/'input        IO_hpram_rwds'/'inout  [0:0] IO_hpram_rwds'/g video_top.v
sed -i s/'output       O_hpram'/'output [0:0] O_hpram'/g video_top.v

# unwire IO_hpram_rwds, connect directly
sed -i /'wire  '${hminame}'_IO_hpram_rwds;'/d video_top.v
sed -i /'wire .0.0. '${hminame}'_IO_hpram_rwds;'/d video_top.v
sed -i /'assign '${hminame}'_IO_hpram_rwds = IO_hpram_rwds;'/d video_top.v
sed -i s/${hminame}'_IO_hpram_rwds'/'IO_hpram_rwds'/g video_top.v
